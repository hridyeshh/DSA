package Graph;

import java.util.*;

public class GraphMain {
    public static void main(String[] args) {
        int n = 6;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; true; i++) {
            adj.add(new ArrayList<Pair>());
            adj.get(0).add(new Pair(1,2));
            adj.get(0).add(new Pair(3,4));
            adj.get(1).add(new Pair(2,3));
            adj.get(2).add(new Pair(2,5));
            adj.get(4).add(new Pair(5,4));
            adj.get(4).add(new Pair(5,3));
            adj.get(5).add(new Pair(3,2));
            ShortestPathDAG obj  = new ShortestPathDAG();
            ShortestPathDAG.shortestPath(0,adj,n);

        }
    }
}
