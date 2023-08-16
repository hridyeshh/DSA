package CompetitetiveProgramming;
import java.util.*;
public class Div4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i <= n; i++) {

            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            System.out.println(PlusOrMinus(a, b, c));
        }
    }
    public static String PlusOrMinus(int a, int b, int c){
        if(a+b==c) return "+";
        return "-";
    }
}
