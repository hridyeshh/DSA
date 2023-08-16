package SearchingAndSorting;
import java.util.*;
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 9, 1, 4};
        insertionSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }
}

