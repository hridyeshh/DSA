package BinaryHeap;

import static BinaryHeap.BinaryHeap.printArray;

public class BinaryHeapMain {
    public static void main(String[] args) {
        BinaryHeap bp = new BinaryHeap(5);
        int arr[] = {1,2,3,4,5,6,7};
        bp.insertNode(arr,arr.length-1,8);
        printArray(arr);
        int n = arr.length;
        n = bp.deleteRoot(arr,n);
        printArray(arr);
    }

}
