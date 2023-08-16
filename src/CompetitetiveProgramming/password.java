package CompetitetiveProgramming;
import java.util.*;
public class password {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            int n = s.nextInt();
            int[] a = new int[n]; // arr of number that are not used in the password
            for (int i = 0; i < n; ++i) a[i] = s.nextInt();
            System.out.println((10 - n) * (9 - n ) * 3);
            t--;
        }
    }
}
