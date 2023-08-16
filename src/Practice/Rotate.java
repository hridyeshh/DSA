package Practice;

import java.util.Arrays;

public class Rotate {

    public static void rotate(int arr[], int n)
    {
        if(n==0) return;
        int[] newArr = new int[n];
        newArr[0] = arr[n-1];
        for(int i = 1;i<arr.length;i++){
            newArr[i] = arr[i-1];
        }
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i]+" ");
        }
    }

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxi = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxi = Math.max(maxi,sum);

            if(sum<0) sum = 0;
        }
        return maxi;
    }

    int getMinDiff(int[] arr, int n, int k) {
        if (arr == null || n <= 0) return -1;
        Arrays.sort(arr);   // 4 7 8 12   k = 3 ==>  1,4 5 9  ==>  9 - 5 =4 ans

        int min = 0, max = 0, res = 0;
        res = arr[n - 1] - arr[0];
        for (int i = 1; i < n; ++i) {
            if (arr[i] >= k) {
                max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
                // because we are supposed to either add or subtract the height
                // only once
                min = Math.min(arr[i] - k, arr[0] + k);

                res = Math.min(res, max - min);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        rotate(arr,arr.length);
    }
}
