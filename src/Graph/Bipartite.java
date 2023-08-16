package Graph;

import java.util.*;

public class Bipartite {
    public static boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;
        while (true) {
            Integer a = q.poll();
            for (Integer it : adj.get(a)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.add(it);
                } else if (color[it] == color[node]) return false;
            }
        }
    }
    public static boolean dfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int[] color) {
        if (color[node] == -1) color[node] = 1;
        for (Integer it : adj.get(node)) {
            if (color[it] == -1) color[it] = 1 - color[node];
            if (!dfsCheck(adj, node, color)) return false;
            else if (color[it] == color[node]) return false;
        }
        return true;
    }
    public static boolean checkBfsBipartite(ArrayList<ArrayList<Integer>> adj, int n) {
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfsCheck(adj, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean checkDfsBipartite(ArrayList<ArrayList<Integer>> adj, int n) {
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(adj, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}
