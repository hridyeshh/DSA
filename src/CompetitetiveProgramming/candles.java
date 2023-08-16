package CompetitetiveProgramming;
import java.util.*;
public class candles {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), ones;
        for (int i = 0; i < n; i++) {
            ones = 0;
            int m = s.nextInt();
            for (int j = 0; j < m; j++)
                if (s.nextInt() == 1) ones++;
            if (ones % 2 != 0) System.out.println("NO");
            else if ((m - ones) % 2 != 0 && ones == 0) System.out.println("NO");
            else System.out.println("yes");
        }
    }
}
