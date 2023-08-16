package DynamicProgramming;

import java.util.*;

public class SumUntilK {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        int[][] dp = new int[n][k + 1];
        Arrays.stream(dp).forEach(A -> Arrays.fill(A, -1));
        return sumUntilMemorisation(0, k, arr, dp);
    }

    // memorisation solution
    public static boolean sumUntilMemorisation(int index, int target, int[] arr, int[][] dp) {
        if (target == 0) return true;
        if (index == arr.length - 1) return arr[index] == target;

        if (dp[index][target] != -1) return dp[index][target] != 0;
        boolean notTaken = sumUntilMemorisation(index + 1, target, arr, dp);
        boolean taken = false;
        if (arr[index] <= target) {
            taken = sumUntilMemorisation(index + 1, target - arr[index], arr, dp);
            dp[index][target] = notTaken || taken ? 1 : 0;
        }
        return notTaken || taken;
    }

    // tabulation solution
    public static boolean sumUntilTabulation(int n, int k, int arr[]) {
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if (arr[i] <= target) {
                    take = dp[i - 1][target - arr[i]];
                }
                dp[i][target] = take | notTake;
            }
        }
        return dp[n - 1][k];
    }

    // as we are always checking the previous row, we can perform space optimisation

    public static boolean sumUntilOptimisation(int n, int k, int[] arr) {
        boolean[] prev = new boolean[k + 1];
        prev[0] = true;
        if (arr[0] <= k) prev[arr[0]] = true;

        for (int i = 1; i < n; i++) {
            boolean[] current = new boolean[k + 1];
            current[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if (arr[i] <= target) {
                    take = prev[target - arr[i]];
                }
                current[target] = take || notTake;
            }
            prev = current;
        }
        return prev[k];
    }

    public static boolean canPartitionQ(int[] arr, int n) {
        int totalSum = Arrays.stream(arr).sum();
        if ((totalSum & 1) == 1) return false;
        else {
            int k = totalSum / 2;
            boolean[][] dp = new boolean[n][k + 1];
            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }
            if (arr[0] <= k) {
                dp[0][arr[0]] = true;
            }

            for (int i = 1; i < n; i++) {
                for (int target = 0; target <= k; target++) {
                    boolean notTake = dp[i - 1][target];
                    boolean take = false;
                    if (arr[i] <= target) {
                        take = dp[i - 1][target - arr[i]];
                    }
                    dp[i][target] = take || notTake;
                }
            }
            return dp[n - 1][k];
        }
    }

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) return false;
        return partitionTwice(nums, sum / 2);
    }

    public static boolean partitionTwice(int[] nums, int totalSum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][totalSum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= totalSum) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= totalSum; target++) {
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if (nums[i] <= target) {
                    take = dp[i - 1][target - nums[i]];
                }
                dp[i][target] = take || notTake;
            }
        }
        return dp[n - 1][totalSum];
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        return partition(nums, sum / k, 0, k, new boolean[nums.length], 0);
    }

    public static boolean partition(int[] nums, int targetSum, int currentSum, int k, boolean[] used, int startIndex) {
        if (k == 0) return true;
        if (currentSum == targetSum) {
            return partition(nums, targetSum, 0, k - 1, used, 0);
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (!used[i] && currentSum + nums[i] <= targetSum) {
                used[i] = true;
            }
            used[i] = false;
        }
        return false;
    }

    public static int minSubsetSumDifference(int[] nums) {
        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();
        boolean[][] dp = new boolean[n][totalSum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= totalSum) { // even if num[0] is == sum == 5(say) then dp[0][5] = true and it means that the sum of 5 can be made through number 5
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= totalSum; target++) {
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if (nums[i] <= target) {
                    take = dp[i - 1][target - nums[i]];
                }
                dp[i][target] = take || notTake;
            }
        }
        int mini = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= totalSum / 2; s1++) {
            if (dp[n - 1][s1]) {
                mini = Math.min(mini, ((totalSum - s1) - s1));
            }
        }
        return mini;
    }

    public static int findWays(int num[], int tar) {
        int n = num.length;
        int[] prev = new int[tar + 1];
        for (int i = 0; i < n; i++) {
            prev[0] = 1;
        }
        if (Math.abs(num[0]) <= tar) {
            prev[num[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            int[] current = new int[tar + 1];
            for (int target = 0; target <= tar; target++) {
                int notTake = prev[target];
                int take = 0;
                if (num[i - 1] <= target) {
                    take = prev[target - num[i - 1]];
                }
                current[target] = take + notTake;
            }
            prev = current;
        }
        return prev[tar];
    }

    static int mod = (int) 1e7;

    public static int countHelper(int[] nums, int tar) {
        int n = nums.length;
        int dp[][] = new int[n][tar + 1];
        if (nums[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;
        if (nums[0] != 0 && nums[0] <= tar) dp[0][nums[0]] = 1;
        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= tar; target++) {
                int notTake = dp[i - 1][target];
                int take = 0;
                if (nums[i] <= target) {
                    take = dp[i - 1][target - nums[i]];
                }
                dp[i][target] = (notTake + take) % mod;
            }
        }
        return dp[n - 1][tar];
    }

    public static int countPartitions(int d, int[] arr) {
        int totalSum = Arrays.stream(arr).sum();
        if (totalSum - d < 0 || ((totalSum - d) & 1) == 1) return 0;
        return countHelper(arr, (totalSum - d) / 2);
    }


    public static int minimumElements(int coins[], int amount) {
        if (amount == 0) return 1;
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) dp[0][i] = 1;
            else dp[0][i] = 0;
        }
        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = dp[i - 1][target];
                int take = 0;
                if (coins[i] <= target) {
                    take = dp[i][target - coins[i]];
                }
                dp[i][target] = take + notTake;
            }
        }
        int ans = dp[n - 1][amount];
        return ans == amount + 1 ? 0 : ans;
    }

    public static int cutRod(int price[], int n) {
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i * price[0];
        }
        for (int i = 1; i < n; i++) {
            for (int length = 0; length <= n; length++) {
                int notTake = dp[i - 1][length];
                int take = Integer.MIN_VALUE;
                int rodLength = i + 1;
                if (rodLength <= length) {
                    take = price[i] + dp[i][length - rodLength];
                }
                dp[i][length] = Math.max(take, notTake);
            }
        }
        return dp[n - 1][n];
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 8, 10};
        System.out.println(cutRod(arr, arr.length));
    }
}