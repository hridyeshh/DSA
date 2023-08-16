package SearchingAndSorting;
import java.util.*;
public class Problems {

    public static void CyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) swap(arr, i, correctIndex);
            else i++;
        }
    }
    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static int kthSmallest(int arr[], int l, int r, int k) {
        merge(arr,l,(l+r)/2,r);
        mergeSort(arr,l,r);
        return arr[k];
    }
    public static void mergeSort(int [] array, int left, int right) {
        if (left<right){
            int mid = left + (right-left)/2;
            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);

            merge(array,left,mid,right);
        }
    }
    public static void merge(int[]array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }
            else{
                array[k] = rightArray[j];
                j++;
            }

            k++;
        }
        while(i<n1){
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while(j<n2){
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }


    public static int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else i++;
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if(nums[i]!=nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        List<Integer> disappearedNumbers = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1) {
                disappearedNumbers.add(j+1);
            }
        }

        return disappearedNumbers;
    }

    static int binarySearch(long[] arr, int target, int start, int end) {
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

    public static ArrayList<Long> find(long arr[], int n, int x) {
        ArrayList<Long> find = new ArrayList<>();
        long firstIndex = firstIndex(arr,n,x);
        long lastIndex = lastIndex(arr,n,x);
        find.add(firstIndex);
        find.add(lastIndex);
        return find;
    }

    private static long firstIndex(long[] arr, int n, int x){
        long s = 0; long e = n-1;long firstIndex = -1;
        while(s<=e){
            long mid = s + (e-s)/2;
            if(arr[(int) mid] == x){
                firstIndex = mid;
                e = mid-1;
            } else if (arr[(int)mid]>x) {
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return firstIndex;
    }
    private static long lastIndex(long[] arr, int n, int x){
        long s = 0; long e = n-1; long lastIndex = -1;
        while(s<=e){
            long mid = s + (e-s)/2;
            if(arr[(int)mid]==x){
                lastIndex = mid;
                s = mid+1;
            } else if (arr[(int)mid]<x) {
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        return lastIndex;
    }

    ArrayList<Integer> valueEqualToIndex(int arr[], int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == i + 1) {
                result.add(i);
            }
        }
        return result;
    }

    public int searchInRotatedArray(int[] nums, int target) {
        int start = 0; int end = nums.length - 1;

        while (start <= end) {
            final int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }

        return -1;
    }

    public static void QuickSort(int[] num, int low, int high){
        if(low>=high) return;
        int s = low;
        int e = high;
        int m = e + (e-s)/2;
        int pivot = num[s];
        while(s<=e){
            if(num[s]<pivot) s++;
            if(num[e]>pivot) e--;
        }
        if(s<=e){
            int temp = num[s];
            num[s] = num[e];
            num[e] = temp;
            s++; e--;
        }
        QuickSort(num,low,e);
        QuickSort(num,s,high);
    }

    static int countSquares(int N) {
        int[] s = new int[(int)Math.sqrt(N)];
        return s.length-1;
    }


    static int majorityElement(int a[], int size){
        int appear = 0;
        int i = 0;
        while(i<a.length){
            if(a[i]!=i+1){
                int correctIndex = a[i]-1;
                if(a[i]!=a[correctIndex]){
                    swap(a,i,correctIndex);
                }
                else{
                    appear++;
                }
            }
            else i++;
        }
        if(appear>size/2){
            return a[i];
        }
        return -1;
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int element = 0;

        for(int num : nums){
            if(count == 0){
                element = num;
            }
            if(num==element) count++;
            else count--;
        }
        return element;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,3,3,2};
        System.out.println(majorityElement(arr,arr.length));
    }

}
