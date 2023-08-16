package DynamicProgramming;
import java.util.*;
public class Adjacent {
    static int MaxSumAdjacent(int ind, int[] arr, int[] dp){
        if(ind<0)  return 0;
        if(ind==0) return arr[ind];
        if(dp[ind]!=-1) return dp[ind];
        int pick= arr[ind]+ MaxSumAdjacent(ind-2, arr,dp);
        int nonPick = MaxSumAdjacent(ind - 1, arr, dp);
        return dp[ind]=Math.max(pick, nonPick);
    }

    static int solve(int[] arr){
        int[] dp =new int[arr.length];
        Arrays.fill(dp,-1);
        return MaxSumAdjacent(arr.length-1, arr, dp);
    }
    public static void main(String[] args) {
        int[] arr ={2,1,4,9};
        System.out.println(solve(arr));
    }
}
