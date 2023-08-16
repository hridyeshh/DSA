package String;

import java.util.Arrays;

public class Concepts {
    public static void main(String[] args) {
        String a = new String("Hridyesh");
        String b  = new String("Hridyesh");
        System.out.println(a==b); // == checks if both the referance variables are
        // pointing to the same object in the heap memory (or string pool) and the values of the referance variables
        System.out.println(a.equals(b)); // .equals checks if the strings have the same values
        String name = null;
        System.out.println(name);
        System.out.println(Arrays.toString(a.toCharArray()));
        float f  = 453.1234f;
        System.out.printf("Formatted number is %.2f", f);
        System.out.println(palindrome("aba"));
    }
    public static boolean palindrome(String s){
        if(s.length() == 0){
            return true;
        }
        s = s.toLowerCase();
        for (int i = 0; i <= s.length()/2; i++) {
            char start = s.charAt(i);
            char end = s.charAt(s.length() - 1-i);
            if(start!=end){
                return false;
            }
        }
        return true;
    }
}
