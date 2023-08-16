package SearchingAndSorting;
import java.util.*;
public class TopologicalSort {
    public static void findTopologicalSort(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node]=1;
        for(Integer it : adj.get(node)){
            if(vis[it]==0){
                findTopologicalSort(it,vis, adj, st);
            }
        }
        st.push(node);
    }
    public static int[] topologicalSort(int n, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<Integer>();
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) findTopologicalSort(i, vis, adj, st);
        }
        int[] topo = new int[n];
        int index = 0;
        while (!st.isEmpty()) topo[index++] = st.pop();
        return topo;
    }
    public static int[] topologicalSortBFS(int n, ArrayList<ArrayList<Integer>> adj){
        int[] topo = new int[n];
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for(Integer it : adj.get(i)) indegree[it]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) if(indegree[i]==0) q.add(i);
        int index = 0;
        while(!q.isEmpty()){
            Integer node = q.poll();
            topo[index++]=node;
            for(Integer it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        return topo;
    }
    public static void shortestPath(ArrayList<ArrayList<Integer>> adj, int n, int src){
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i]= 100000000;
            Queue<Integer> q = new LinkedList<>();
            dist[src]=0;
            q.add(src);
            while(true){
                int node = q.poll();
                for(int it :adj.get(node)){
                    if(dist[node]+1<dist[it]){
                        dist[it] = dist[node]+1;
                        q.add(it);
                    }
                }
                for (int j = 0; j < n; j++) {
                    System.out.println(dist[j]+" ");
                }
            }
        }
    }
}
