package SearchingAndSorting;
import java.util.*;
public class FindDuplicate {

    public static int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                int correctIndex = nums[i] - 1;
                if (nums[i] != nums[correctIndex]) {
                    swap(nums, i, correctIndex);
                }
                else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (final int num : nums) {
            nums[Math.abs(num) - 1] *= -1;
            if (nums[Math.abs(num) - 1] > 0)
                ans.add(Math.abs(num));
        }

        return ans;
    }

    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i];
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else i++;
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public int missingNum(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else i++;
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }


    public static void main(String[] args) {
        System.out.println(Math.abs(-3.14));
    }
}
