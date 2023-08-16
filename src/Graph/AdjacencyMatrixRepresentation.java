package Graph;
import java.util.*;
public class AdjacencyMatrixRepresentation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n is the number of vertices
        int m = sc.nextInt(); // m is the number of edges
        int[][] adjMat = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjMat[u][v] = 1;
            adjMat[v][u] = 1;
        }
    }
}
