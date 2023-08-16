package StacksAndQueses;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackMain {
    public static void main(String[] args) throws Exception {
        CustomStack stack = new CustomStack(5);
        System.out.println("Stack outputs - ");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop()+ " ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.println(stack.pop()+" ");

        DynamicStack Dstack = new DynamicStack(5);
        System.out.println("Dynamic stack output - ");
        Dstack.push(1);
        Dstack.push(2);
        Dstack.push(3);
        Dstack.push(4);
        Dstack.push(5);
        Dstack.push(6);
        System.out.print(Dstack.pop()+" ");
        System.out.print(Dstack.pop()+" ");
        System.out.print(Dstack.pop()+" ");
        System.out.print(Dstack.pop()+" ");
        System.out.print(Dstack.pop()+" ");
        System.out.print(Dstack.pop());

        CircularQueue Cstack = new CircularQueue(5);
        System.out.println("Circular queue outputs - ");
        Cstack.insert(1);
        Cstack.insert(2);
        Cstack.insert(3);
        Cstack.insert(4);
        Cstack.insert(5);
        Cstack.display();

        Deque deque = new ArrayDeque();
    }
}
