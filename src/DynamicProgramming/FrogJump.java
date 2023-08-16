package DynamicProgramming;
import java.util.*;
public class FrogJump {
    static int solve(int ind,int[] height,int[] dp){
        if(ind==0)return 0;
        if(dp[ind]!=-1) return dp[ind];
        int jumpTwo = Integer.MAX_VALUE;
        int jumpOne = solve(ind-1,height,dp)+Math.abs(height[ind]-height[ind-1]);
        if(ind>1) jumpTwo = solve(ind-2,height,dp)+Math.abs(height[ind]-height[ind-2]);
        return Math.min(jumpOne,jumpTwo);
    }
    static int solveUtil(int ind, int[] height, int[] dp, int k){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int mmSteps = Integer.MAX_VALUE;

        for(int j=1;j<=k;j++){
            if (ind-j>=0){
                int jump = solveUtil(ind-j, height, dp, k)+ Math.abs(height[ind]-
                        height[ind-j]);
                mmSteps= Math.min(jump, mmSteps);
            }
        }
        return dp[ind]= mmSteps;
    }
    static int solveK(int n, int[] height , int k){
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return solveUtil(n-1, height, dp, k);
    }
    public static void main(String[] args) {

        int[] height ={30,10,60,10,60,50};
        int n=height.length;
        int[] dp =new int[n];
        Arrays.fill(dp,-1);
        System.out.println("Frog jumping either 1 step or 2 : "+solve(n-1,height,dp));

        int k=2;
        System.out.println("From jumping " +k+" steps : "+solveK(n,height,k));
    }
}
