package StacksAndQueses;

public class CustomQueue {
    private int [] data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }
    public CustomQueue(int size){
        this.data = new int[size];
    }
    private boolean isFull() {
        return end == data.length; // end is at the last index that means ptr++ will result in giving stack overflow error
    }
    private boolean isEmpty(){
        return end == 0; // end is not pointing to anything as the queue is empty
    }
    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++] = item;
        return true;
    }
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        int removed = data[0];
        // shifting of elements to left
        for (int i = 1; i <end ; i++) {
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }
    public int front() throws Exception{ // return the first element
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[0];
    }
    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println("END");
    }

}

