package Practice;
import java.util.*;

class GFG
{
    static int N = 100000;


    static Vector<Integer>[] gr1 = new Vector[N];
    static Vector<Integer>[] gr2 = new Vector[N];

    static boolean[] vis1 = new boolean[N];
    static boolean[] vis2 = new boolean[N];

    static {
        for (int i = 0; i < N; i++)
        {
            gr1[i] = new Vector<>();
            gr2[i] = new Vector<>();
        }
    }

    static void Add_edge(int u, int v)
    {
        gr1[u].add(v);
        gr2[v].add(u);
    }


    static void dfs1(int x)
    {
        vis1[x] = true;
        for (int i : gr1[x])
            if (!vis1[i])
                dfs1(i);
    }


    static void dfs2(int x)
    {
        vis2[x] = true;
        for (int i : gr2[x])
            if (!vis2[i])
                dfs2(i);
    }

    static boolean Is_connected(int n) {


        Arrays.fill(vis1, false);
        dfs1(1);


        Arrays.fill(vis2, false);
        dfs2(1);

        for (int i = 1; i <= n; i++) {
            if (!vis1[i] && !vis2[i])
                return false;
        }
            return true;
        }

    public static void main(String[] args)
    {
        int n = 4;

        Add_edge(1, 2);
        Add_edge(1, 3);

        if (Is_connected(n))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
