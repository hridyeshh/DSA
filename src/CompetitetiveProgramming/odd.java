package CompetitetiveProgramming;

import java.util.Scanner;

public class odd {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if ((n & 1) == 1) {
            System.out.println("no");
        } else {

            System.out.println("yes");
        }
    }
}
