package SearchingAndSorting;

public class CountSort {
    public static void countSort(int[]arr, int max, int min) {
        int range = max - min + 1;
        int[] ans = new int[arr.length];
        //make frequency arr
        int[] farr = new int[range];
        for (int i = 0; i < arr.length; i++) {
            farr[arr[i] - min]++;
        }
        //convert it into prefix sum array
        for (int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }
        //stable sorting(filling ans array)
        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = farr[arr[i] - min] - 1;
            ans[pos] = arr[i];
            farr[arr[i] - min]--;
        }
        //filling original array with the help of ans array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
    }
}
