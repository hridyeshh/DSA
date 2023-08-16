package SearchingAndSorting;
import java.util.*;
public class SelectionSort {
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Find the minimum element in the remaining unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the minimum element with the current element
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 2, 1, 4};
        selectionSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}

