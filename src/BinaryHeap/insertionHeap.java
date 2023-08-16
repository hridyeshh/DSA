package BinaryHeap;

public class insertionHeap {
    public static void heapify2(int[]arr, int n, int i){
        int parent = (i-1)/2;
        if(arr[parent]>0){
            if(arr[i]>arr[parent]){
                // swap arr[i] with arr[parent]
                int temp = arr[i];
                arr[i] = arr[parent];
                arr[parent] = temp;

                heapify2(arr,n,parent);
            }
        }
    }
    public static int insertNode(int[]arr, int n, int val) {
        n += 1; // increasing the size of the array
        arr[n - 1] = val; // inserting the value at the end of the arr

        heapify2(arr, n, n - 1);
        return arr[n - 1]; // return the inserted element in the array
    }
    // extract a node means deleting the root node
    public static void deleteRoot(int[]arr, int n){
        int lastElement = arr[n-1];
        arr[0] = lastElement;
        n-=1;
        heapify2(arr,n,0);
    }
    public static void delete(int[]arr, int length,  int index){
        if(index==0) {
            deleteRoot(arr, 0);
        }
        for (int i = index; i <= length ; i++) {
            arr[i+1]=arr[i];
            length--;
        }
    }
    public static void printArray(int[] arr)
    {
        for (int i : arr) System.out.println(i + " ");
        System.out.println();
    }

}
