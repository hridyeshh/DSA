package SearchingAndSorting;
import java.util.*;
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 2, 1, 4};
        bubbleSort(array);
        System.out.println("Binary Sorted array: " + Arrays.toString(array));
    }
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}