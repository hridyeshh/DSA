package Graph;

public class KnapSackDP {
    public static int knapSack(int W, int wt[], int val[], int n) {
        if (n == 0 || W == 0) return 0;
        if (wt[n - 1] > W) return knapSack(W, wt, val, n - 1);
        else
            return Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1));
    }
    public static void main(String args[]){
        int val[] = new int[] {10, 15, 30};
        int wt[] = new int[] { 60, 150, 120};
        System.out.println(knapSack(180, wt, val, val.length));
    }
}
