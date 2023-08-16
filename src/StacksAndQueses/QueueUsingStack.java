package StacksAndQueses;

import java.util.Stack;

public class QueueUsingStack {

    private Stack<Integer> first;
    private Stack<Integer> second;

    public void MyQueue(){
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        first.peek();
        return second.pop();
    }

    public int peek() {
        if(second.isEmpty()){
            while(!first.isEmpty()){
                second.push(first.pop());
            }
        }
        return second.peek();
    }

    public boolean empty() {
        return (first.empty() && second.isEmpty());
    }
}
