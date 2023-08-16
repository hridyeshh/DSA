package Graph;

import java.util.*;

public class CheckCycleDFS {
    public static boolean checkForCycle(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        for (Integer it : adj.get(node)) {
            if (checkForCycle(it, node, vis, adj)) return true;
            else if (it != parent) return true;
        }
        return false;
    }
    public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (checkForCycle(i, -1, vis, adj)) {
                    System.out.println("Cyclic");
                    return true;
                }
                else System.out.println("Acyclic");
            }
        }
        return false;
    }
}

