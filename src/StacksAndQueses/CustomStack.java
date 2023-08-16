package StacksAndQueses;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1; // when incremented, will point to the items in the queue
    public CustomStack() {
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size){
        this.data = new int[size];
    }
    public boolean push(int item){ // to check if inserted or not
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        ptr++; // incrementing to point to the first index in the starting
        data[ptr]=item;
        return true;
    }
    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot pop from an empty queue");
        }
//        int removed = data[ptr];
//        ptr--;
//        return removed;
        return data[ptr--];
    }
    public int peek() throws StackException{
        if(isEmpty()){
            throw new StackException("Cannot peek from an empty queue");
        }
        return data[ptr];
    }
    public boolean isFull() {
        return ptr == data.length-1; // ptr is at the last index that means ptr++ will result in giving stack overflow error
    }
    private boolean isEmpty(){
        return ptr == -1; // ptr is not pointing to anything as the queue is empty
    }

}
