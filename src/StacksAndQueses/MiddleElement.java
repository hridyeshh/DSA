package StacksAndQueses;

import java.util.Stack;
public class MiddleElement {
    public static int findMiddleElement(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        Stack<Integer> middleStack = new Stack<>();

        while(!stack.isEmpty()){
            tempStack.push(stack.pop());
        }
        int size = tempStack.size();
        int middleIndex = size/2;

        for (int i = 0; i < middleIndex; i++) {
            middleStack.push(tempStack.pop());
        }
        int middleElement = tempStack.pop();

        while(!middleStack.isEmpty()){
            stack.push(middleStack.pop());
        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return middleElement;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        int middleElement = findMiddleElement(stack);
        System.out.println("Middle element: " + middleElement);
    }
}
