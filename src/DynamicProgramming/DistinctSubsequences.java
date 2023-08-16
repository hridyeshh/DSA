package DynamicProgramming;

import java.util.*;

public class DistinctSubsequences {

    // memorisation solution
    private static int helperDistinct(int i, int j, String s, String t, int[][] dp){
        if(j < 0) return 1;
        if(i < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = helperDistinct(i-1, j-1, s, t, dp) +
                    helperDistinct(i-1, j, s, t, dp);
        }
        return dp[i][j] = helperDistinct(i-1, j, s, t, dp);
    }

    // tabulation solution
    public static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    // optimised solution
    public static int numDistinctOptimised(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m+1];
        prev[0] = 1;
        for (int i = 1; i <= n ; i++) {
            for (int j = m; j >= 1 ; j--) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    prev[j] = prev[j] + prev[j-1];
                }
            }
        }
        return prev[m];
    }

    public static void main(String[] args) {
        System.out.println(numDistinctOptimised("rabbbit", "rabbit"));
    }
}
