package Arrays;

import java.util.*;

public class Problems {
    public static void main(String[] args) {
        int[] array = {1,2,2,4,5};
        System.out.println(Arrays.toString(reverseArray(array)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            if (numToIndex.containsKey(target - nums[i]))
                return new int[] {numToIndex.get(target - nums[i]), i};
            numToIndex.put(nums[i], i);
        }

        return new int[]{-1,-1};
    }

    public int getMinDiff(int[] arr, int n, int k) {
        if (arr == null || n <= 0) return -1;
        Arrays.sort(arr);

        int min = 0, max = 0;
        int res = arr[n - 1] - arr[0];
        for (int i = 1; i < n; ++i) {
            if (arr[i] >= k) {
                max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
                min = Math.min(arr[i] - k, arr[0] + k);
                res = Math.min(res, max - min);
            }
        }
        return res;
    }

    static int minJumps(int[] arr){
        int n = arr.length;
        int jumps = -1;
        for (int i = 0; i < n; i++) {
            if(arr[i]*arr[i]==n){

            }
        }
        return jumps;
    }

    public static int[] reverseArray(int[] array) {
        for (int i = 0; i < array.length/2; i++) {
            int temp = array[i];
            array[i]=array[array.length-i-1];
            array[array.length-i-1] = temp;
        }
        return array;
    }
}
