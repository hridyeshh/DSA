package StacksAndQueses;

public class KStacks {
    private final int[] arr;       // Array to store the elements
    private final int[] top;       // Array to store the top index of each stack
    private final int[] next;      // Array to store the next available index
    private int n, k;        // Size of array and number of stacks
    private int freeSpot;        // Index of the next free slot in the array

    // Constructor to initialize the k stacks with given size
    KStacks(int k, int n) {
        this.k = k;
        this.n = n;
        arr = new int[n];
        top = new int[k];
        next = new int[n];

        // Initialize all stacks as empty
        for (int i = 0; i < k; i++)
            top[i] = -1;

        // Initialize all slots as free
        freeSpot = 0;
        for (int i = 0; i < n - 1; i++)
            next[i] = i + 1;
        next[n - 1] = -1;
    }

    // Function to check if a stack is empty
    boolean isEmpty(int stackNum) {
        return (top[stackNum] == -1);
    }

    // Function to check if a stack is full
    boolean isFull() {
        return (freeSpot == -1);
    }

    // Function to push an element onto a stack
    void push(int value, int stackNum) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }

        int index = freeSpot;        // Get the next free slot
        freeSpot = next[index];      // Update the next free slot

        arr[index] = value;      // Store the value in the array

        // Update the next index of the current top and set the new top index
        next[index] = top[stackNum];
        top[stackNum] = index;
    }

    // Function to pop an element from a stack
    int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int i = top[stackNum];      // Get the index of the top element
        int value = arr[i];         // Get the value at the top element
        top[stackNum] = next[i];    // Update the top index
        next[i] = freeSpot;         // Set the current slot as free
        freeSpot = i;               // Update the next free slot

        return value;
    }
}
