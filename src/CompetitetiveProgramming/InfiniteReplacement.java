package CompetitetiveProgramming;
import java.util.*;
public class InfiniteReplacement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) { // n times iteration == O(n)
            String a = s.next();
            String b = s.next();
            if (b.contains('a' + "") && b.length() == 1){
                System.out.println(1);
            }
            else if (b.contains('a' + "") && b.length() != 1) {
                System.out.println(-1);
            } else {
                System.out.println((long) Math.pow(2, a.length()));
            }
        }
    }
}
