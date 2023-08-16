package Graph;
import java.util.*;
public class CustomGraph {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        // function to add an edge in an undirected graph

        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static ArrayList<Integer> bfsGraph(int v, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[v+1]; // v+1 because the indexing is starting from 1

        for (int i = 0; i <=v; i++) {
            if(!vis[i]){ // check for unvisited node
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    vis[i] = true; // after insertion into the queue, the integer
                // is marked true that means it's visited

                while(!q.isEmpty()){
                    Integer node = q.poll(); // topmost element is deleted from the queue
                    bfs.add(node);

                    for(Integer x : adj.get(node)){
                        if(!vis[i]){
                            vis[i] = true;
                            q.add(x);
                        }
                    }
                }
            }
        }
        return bfs;
    }
    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storeDFS){
        storeDFS.add(node);
        vis[node]=true;
        for(Integer it : adj.get(node)){
            if(!vis[it]){
                dfs(node, vis, adj, storeDFS);
            }
        }
    }
    public static ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> storeDfs = new ArrayList<>();
        boolean[] vis = new boolean[v+1];
        for (int i = 1; i <=v ; i++) {
            if(vis[i]){
                dfs(i,vis,adj,storeDfs);
            }
        }
        return storeDfs;
    }
    public static void shortestPath(ArrayList<ArrayList<Integer>> adj, int n, int src) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = 100000000;
            Queue<Integer> q = new LinkedList<>();
            dist[src] = 0;
            q.add(src);
            while (true) {
                int node = q.poll();
                for (int it : adj.get(node)) {
                    if (dist[node] + 1 < dist[it]) {
                        dist[it] = dist[node] + 1;
                        q.add(it);
                    }
                }
                for (int j = 0; j < n; j++) {
                    System.out.println(dist[j] + "->");
                }
            }
        }
    }
    public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }
}