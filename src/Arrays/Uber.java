package Arrays;
import java.util.*;
public class Uber {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{8, 6, 6, 8, 9, 8}));
    }

    static boolean solution(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        int average = sum / a.length;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != average) {
                return false;
            }
        }
        return true;
    }

    static long[] solution1(int t, long[][] carPrices) {
        int n = carPrices.length;
        long[] result = new long[n];
        long[] cumulativeSum = new long[t + 1];

        for (int i = 0; i < n; i++) {
            int k = carPrices[i].length;
            for (int j = 0; j < k; j++) {
                cumulativeSum[j + 1] += carPrices[i][j];
            }
        }

        for (int x = 1; x <= t; x++) {
            int count = 0;
            for (int j = 0; j <= t; j++) {
                if ((j & x) == x) {
                    result[count++] = cumulativeSum[j];
                }
            }
            Arrays.sort(result, 0, count);
            for (int j = 0; j < count; j++) {
                cumulativeSum[j + 1] += result[j];
            }
        }

        return Arrays.copyOfRange(cumulativeSum, 1, t + 1);
    }

}
