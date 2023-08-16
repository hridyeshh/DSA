package Graph;
import java.util.*;
public class ShortestPathDAG {
    public static void topologicalSort(int node, Boolean[] vis, Stack stack, ArrayList<ArrayList<Pair>> adj) {
        vis[node] = true;
        for (Pair it : adj.get(node)) {
            if (!vis[it.getV()]) {
                topologicalSort(it.getV(), vis, stack, adj);
            }
        }
        stack.add(node);
    }

    public static void shortestPath(int s, ArrayList<ArrayList<Pair>> adj, int n) {
        Stack stack = new Stack();
        int[] dist = new int[n];
        Boolean[] vis = new Boolean[n];
        for (int i = 0; i < n; i++) {
            vis[i] = false;
        }
        for (int i = 0; i < n; i++) {
            if(!vis[i]){
                topologicalSort(i, vis, stack, adj);
            }
        }
        for (int i = 0; i < n; i++) dist[i]=Integer.MAX_VALUE;
        dist[s]=0;
        while(!stack.isEmpty()){
            int node = (int) stack.pop();
            if(dist[node]!=Integer.MAX_VALUE){
                for(Pair it : adj.get(node)){
                    if(dist[node]+it.getWeight()<dist[it.getV()]){
                        dist[it.getV()] = dist[node]+it.getWeight();
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]+" -> ");
        }
    }
}