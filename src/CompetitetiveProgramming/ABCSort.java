package CompetitetiveProgramming;
import java.util.Arrays;
import java.util.Scanner;
public class ABCSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int test = s.nextInt();
            int[] a = new int[test];
            for (int j = 0; j < test; j++) {
                a[j] = s.nextInt();
            }
            System.out.println(equal(a, test));
        }
    }

    public static String equal(int[] arr, int n) {
        int[] b = arr.clone();
        Arrays.sort(b);

        for (int i = n - 1; i > 0; i -= 2) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
        }
        return Arrays.equals(arr, b) ? "YES" : "NO";
    }
}