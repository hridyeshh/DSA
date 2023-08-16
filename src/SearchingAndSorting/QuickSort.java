package SearchingAndSorting;
import java.util.*;
public class QuickSort {
    public static void Quicksort(int[] num, int low, int high){
        if(low>=high) return;
        int s = low;
        int e = high;
        int m = s + (e-s)/2;
        int pivot = num[m]; // taking the middle element as the pivot
        while(s<=e){
            while(num[s]<pivot) s++;
            while(num[e]>pivot) e--;
            if(s<=e){
                int temp = num[s];
                num[s] = num[e];
                num[e] = temp;
                s++;
                e--;
            }
        }
        // now, sorting the two halves
        Quicksort(num,low,e);
        Quicksort(num,s,high);
    }

    public static void main(String[] args) {
        int[] arr = {2,4,3,5,6};
        Quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}