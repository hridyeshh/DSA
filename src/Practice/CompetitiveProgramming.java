package Practice;

import java.util.*;

public class CompetitiveProgramming {


    public static boolean Watermelon(int w) {

        if ((w & 1) == 1) {
            return false;
        }
        return true;
    }
    public static void sum(int a,int b,int c){
        if(a+b==c || b+c==a || a+c==b){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
//        if((n&1)==1){
//            System.out.println("no");
//        }else{
//
//            System.out.println("yes");
//        }
//        int n = s.nextInt();
//        for (int i = 0; i < n; i++) {
//
//            int a = s.nextInt();
//            int b = s.nextInt();
//            int c = s.nextInt();
//            if (a + b == c || b + c == a || a + c == b) {
//                System.out.println("yes");
//            } else {
//                System.out.println("no");
//            }
//        }
        for (int i = 0; i < n; i++) {
            int a = s.nextInt();
            int[] arr = new int[a];
            if (a > 0) {

                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }

    }
}
