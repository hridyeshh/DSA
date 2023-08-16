package Practice;

import java.util.*;
class CheckCycleDfs {

    private int V;

    private LinkedList<Integer> adj[];

    public CheckCycleDfs(int v){
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }
    void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }
    public Boolean isCyclic(int v, Boolean visited[], int parent){
        visited[v] = true;
        Integer i;
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                if (isCyclic(i, visited, v))
                    return true;
            }
            else if (i != parent)
                return true;
        }
        return false;
    }
    public static void main(String args[]){
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        g1.addEdge(4,4);
        if (g1.isCyclic)
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph is acyclic");

    }
}
