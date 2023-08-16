package BinaryHeap;

import java.util.ArrayList;

public class BinaryHeap {
    int[] arr;
    int sizeOfTree;

    public BinaryHeap(int size) {
        arr = new int[size + 1]; // size+1 because we are leaving the 0th index
        this.sizeOfTree = 0;
        System.out.println("Binary heap is created of size : " + size);
    }

    public boolean isEmpty() {
        return sizeOfTree == 0;
    }

    public Integer peek() {
        if (isEmpty()) return null;
        return arr[1];
    }

    public int sizeofBP() {
        return sizeOfTree;
    }

    public void levelOrder() {
        for (int i = 1; i < sizeOfTree; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // initialise largest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // if the left child is greater than the root node
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        // if the right child is greater than the root node
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // if the root is not the largest
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static int deleteRoot(int[] arr, int n) {
        int lastElement = arr[n - 1];
        arr[0] = lastElement;
        n -= 1;
        heapify(arr, arr.length, 0);
        return n;
    }

    public static int insertNode(int[] arr, int n, int val) {
        n += 1; // increasing the size of the array
        arr[n - 1] = val; // inserting the value at the end of the arr

        heapify(arr, n, n - 1);
        return arr[n - 1]; // return the inserted element in the array
    }

    public static void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
    public static void deleteHeap(int[] arr){
        arr = null;
        System.out.println("the binary heap has been deleted");
    }
}

