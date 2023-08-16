package StacksAndQueses;

import java.util.*;

public class Problems {

    static boolean isPar(String x) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == '}' && top != '{') || (c == ']' && top != '[') || (c == ')' && top != '(')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public String reverse(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            stack.push(S.charAt(i));
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }


}
