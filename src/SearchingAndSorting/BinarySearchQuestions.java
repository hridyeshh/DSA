package SearchingAndSorting;
public class BinarySearchQuestions {

    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }
    public static int ceiling(int[]letters, int target) {
        int start = 0;
        int end = letters.length-1;
        while(start<=end){
            int mid = start + (end-start)/2; // binary search equation

            if(target<letters[mid]){
                end = mid-1;
            }
            else {
                start = mid+1;
            }

        }
        return letters[start% letters.length]; // returning the first element of the letters created as the ceiling value
    }
    public static int floor(int[]arr, int target) {
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;

            if(target<arr[mid]){
                end = mid-1;
            }
            else if(target>arr[mid]){
                start = mid+1;
            }
            else{
                return mid;

            }
        }
        return arr[end]; // returning the last element of the arr created as the floor element
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        ans[0] = searchIndex(nums,target,true);
        if(ans[0]!=-1) ans[1] = searchIndex(nums,target,false);
        return ans;
    }
    public static int InfiniteArraySearch(int[] nums, int target, int start, int end){
        while(start<=end){
            int mid = start + (end-start)/2;

            if(target<nums[mid]){
                end = mid-1;
            }
            else if(target>nums[mid]){
                start = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    static int helper(int[] arr, int target){
        // starting with the array of size 2
        int start = 0;
        int end = 1;

        while(target>arr[end]){
            int temp = end+1;
            end+=(end-start+1)*2;
            start = temp;
        }
        return InfiniteArraySearch(arr,target,start,end);
    }

    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start<end){
            int mid = start + (end-start)/2;

            if(arr[mid]>arr[mid+1]){
                end = mid;
            }
            else if(arr[mid]<arr[mid+1]){
                start = mid+1;
            }
            else{
                return mid;

            }
        }
        return start;
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            final int mid = start + (end-start)/2;
            if (nums[mid] == target)
                return mid;
            if (nums[start] <= nums[mid]) { // nums[start..mid] are sorted
                if (nums[start] <= target && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else { // nums[mid..n - 1] are sorted
                if (nums[mid] < target && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }

        return -1;
    }

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int searchPivot(int[] nums, int target) {
        int pivot = findPivot(nums);

        // if you did not find a pivot, it means the array is not rotated
        if (pivot == -1) {
            // just do normal binary search
            return binarySearch(nums, target, 0 , nums.length - 1);
        }

        // if pivot is found, you have found 2 asc sorted arrays
        if (nums[pivot] == target) {
            return pivot;
        }

        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    static int orderAgnosticBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    static int searchIndex(int[] nums, int target, boolean findStartIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2; // binary search equation

            if(target<nums[mid]){
                end = mid-1;
            }
            else if(target>nums[mid]){
                start = mid+1;
            }
            else{
                // potential answer found
                ans = mid;
                if(findStartIndex) end = mid-1;
                else start=mid+1;
            }
        }
        return ans;
    }

    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        for (int j : nums) {
            start = Math.max(start, j);
            end += j;
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int pieces = 1;
            for(int num : nums) {
                if (sum + num > mid) {
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces > k) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }
        return end; // here start == end
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,7};
        System.out.println(ceiling(arr,6));
        System.out.println(floor(arr,4));
    }
}
