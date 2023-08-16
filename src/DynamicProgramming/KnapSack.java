package DynamicProgramming;
import java.util.*;
public class KnapSack {
    public static void main(String[] args) {
        int[] profit = {1,2,3};
        int[] weight = {4,5,1};
        System.out.println(knapSack(4, weight,profit,3 ));
    }


    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return knapsackMemorisation(n - 1, w, profit, weight, dp);
    }

    // Memorisation method
    public static int knapsackMemorisation(int index, int W, int[] profit, int[] weight, int[][] dp) {
        if (W == 0) return 0;
        if (index == 0) return (int) (W / weight[0]) * profit[0];
        if (dp[index][W] != -1) return dp[index][W];

        int NotTake = knapsackMemorisation(index - 1, W, profit, weight, dp);
        int take = Integer.MIN_VALUE;
        if (weight[index] <= W) {
            take = profit[index] + knapsackMemorisation(index, W - weight[index], profit, weight, dp);
        }
        return dp[index][W] = Math.max(take, NotTake);
    }

    // tabulation method
    public static int knapsackTabulation(int n, int w, int[] profit, int[] weight){
        int[][] dp = new int[n][w+1];
        for (int i = weight[0]; i <= w; i++) {
            dp[0][i] = (i/weight[0]*profit[0]);
        }
        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= w; target++) {
                int notTake = dp[i-1][target];
                int take = Integer.MIN_VALUE;
                if(weight[i] <= target){
                    take = profit[i] + dp[i][target - weight[i]];
                }
                dp[i][target] = Math.max(take, notTake);
            }
        }
        return dp[n-1][w];
    }

    static int knapSack(int W, int wt[], int val[], int n){
        int[][] dp = new int[n][W+1];
        for (int i = 0; i <= W; i++) {
            if (wt[0] <= i) {
                dp[0][i] = val[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= W; target++) {
                int notTake = dp[i-1][target];
                int take = 0;
                if (wt[i] <= target) {
                    take = val[i] + dp[i-1][target - wt[i]];
                }
                dp[i][target] = Math.max(take, notTake);
            }
        }

        return dp[n-1][W];
    }
    // space optimised solution
    public static int optimisedKnapsack(int W, int wt[], int val[], int n){
        int[] prev = new int[W+1];
        for (int i = wt[0]; i <=W ; i++) {
            prev[i] = (i/wt[0])*val[0];
        }
        for (int i = 1; i < n; i++) {
            int[] current = new int[W+1];
            for (int target = 0; target <= W; target++) {
                int notTake = prev[target];
                int take = 0;
                if(wt[i] <= target){
                    take += prev[target-wt[i]];
                }
                current[target] = take;
            }
            prev = current;
        }
        return prev[W];
    }
}
