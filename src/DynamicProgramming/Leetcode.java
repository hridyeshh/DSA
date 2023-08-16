package DynamicProgramming;

import java.util.*;

public class Leetcode {
    public static int climbStairs(int n) {
        int prev1 = 1;
        int prev2 = 1;
        for (int i = 2; i <= n; i++) {
            int dp = prev1 + prev2;
            prev2 = prev1;
            prev1 = dp;
        }
        return prev1;
    }

    public static int fib(int n) {
        if(n==0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for (int i = 2; i < n; i++) {
            cost[i] += Math.min(cost[i-1],cost[i-2]);
        }
        return Math.min(cost[n-1], cost[n-2]);
    }

    public static int rob(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;
        for(int num : nums){
            int dp = Math.max(prev1, prev2+num);
            prev2 = prev1;
            prev1 = dp;
        }
        return prev1;
    }

    public static int robUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max1 = robLinear(nums, 0, nums.length - 2);
        int max2 = robLinear(nums, 1, nums.length - 1);

        return Math.max(max1, max2);
    }

    private static int robLinear(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {
            int dp  = Math.max(prev1, prev2+ nums[i]);
            prev2 = prev1;
            prev1 = dp;
        }

        return prev1;
    }



    public static int deleteAndEarn(int[] nums) {
        int[] bucket = new int[10001];

        for (int num : nums)
            bucket[num] += num;

        int prev1 = 0;
        int prev2 = 0;

        for (int num : bucket) {
            int dp = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = dp;
        }

        return prev1;
    }

    public static int countMaximum(int day, int last, int[][] points, int[][] dp){
        if(dp[day][last] != -1) return dp[day][last];

        if(day==0){
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if(i!=last){
                    maxi = Math.max(maxi,points[0][i]);
                }
            }
            return dp[day][last] = maxi;
        }
        int maxi = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                maxi = Math.max(maxi, points[day][i] + countMaximum(day - 1, i, points, dp));
            }
        }
        return dp[day][last] = maxi;
    }

    public static int NinjaTraining(int n, int[][]points){
        int[][] dp = new int[n][4];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return countMaximum(n-1,3,points,dp);
    }

    public static int uniquePaths(int m, int n) {
        if(m==1 || n==1) return 1;
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(A ->Arrays.fill(A,1));
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];

    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i > 0 && j > 0){
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                } else if (i>0) {
                    grid[i][0] += grid[i-1][0];
                } else if (j > 0) {
                    grid[0][j] += grid[0][j-1];
                }
            }
        }
        return grid[m-1][n-1];
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; --i)
            for (int j = 0; j <= i; ++j)
                triangle.get(i).set(j, triangle.get(i).get(j) +
                        Math.min(triangle.get(i + 1).get(j),
                                triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int i = 1; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                int min = Integer.MAX_VALUE;
                for (int k = Math.max(0, j - 1); k < Math.min(n, j + 2); ++k)
                    min = Math.min(min, matrix[i - 1][k]);
                matrix[i][j] += min;
            }

        return Arrays.stream(matrix[n - 1]).min().getAsInt();
    }


    public static int uniquePaths1D(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1]; // it will fill the row with size n for one iteration of j
            }
        }
        return dp[n - 1];
    }
    public static int uniquePathsWithObstacles1D(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j]==1) dp[j] = 0;
                else if (j>0) dp[j] += dp[j-1];
            }
        }
        return dp[obstacleGrid[0].length-1];
    }

    public static int uniquePathsIII(int[][] grid) {
        int step = 0, sx = 0, sy = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) step++;
                else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        return allPathPrint(grid,sx,sy,step);
    }
    public static int allPathPrint(int[][] maze, int row, int column, int step){
        if(row < 0 || column < 0 || row >= maze.length || column >= maze[0].length || maze[row][column] == -1)
            return 0;
        if(maze[row][column] == 2){
            return step == -1 ? 1:0;
        }
        maze[row][column] = -1;
        step--;
        int totalPaths = allPathPrint(maze, row+1, column, step) +
                allPathPrint(maze, row, column+1, step) +
                allPathPrint(maze, row-1,column,step) +
                allPathPrint(maze, row, column-1, step);
        maze[row][column] = 0;

        return totalPaths;
    }

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || j == 0 || matrix[i][j] == '0'){
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    // it represents if it's the first cell i.e (0,0) and if it's 1, then
                    // dp[i][j] == 1 and return 1, that is the area is 1.
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength*maxLength;
    }

    public static long count(int coins[], int N, int sum) {
        List<List<Long>> finalList = new ArrayList<>();
        return helper(0, coins, sum, new ArrayList<>(), finalList);
    }

    public static long helper(int s, int[] coins, int sum, List<Long> list, List<List<Long>> finalList) {
        Arrays.sort(coins);
        long ways = 0;
        if (sum < 0) return 0;
        if (sum == 0) return 1;
        for (int i = s; i < coins.length; i++) {
            list.add((long) coins[i]);
            ways += helper(i, coins, sum - coins[i], list, finalList);
            list.remove(list.size() - 1);
        }
        return ways;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
    }
}