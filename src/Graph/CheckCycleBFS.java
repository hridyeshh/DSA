package Graph;
import java.util.*;
public class CheckCycleBFS {
    public static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean[] vis) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, -1));
        vis[s] = true;

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();

            for (Integer it : adj.get(node)) {
                if (!vis[it]) {
                    q.add(new Node(it, node)); // the first node will be 'it' and the second node will be the 'node'
                    // 'it' is the child node and 'node' is the parent node
                    vis[it] = true;
                } else if (par != it) return true;
            }
        }

        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] vis = new boolean[V];
        Arrays.fill(vis,false);
        for(int i=0;i<V;i++)
            if(!vis[i])
                if(checkForCycle(adj, i,vis))
                    return true;

        return false;
    }
}
