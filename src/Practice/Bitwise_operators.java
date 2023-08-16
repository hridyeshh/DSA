package Practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Bitwise_operators {
    public static int[] Unique(int arr[]){
        int []uniqueArr = {};
        int unique = 0;
        for(int n : arr){

        }
        return uniqueArr;
    }
    public static int MagicNumber(int n){
        int ans = 0;
        int base = 5;
        while(n>0){
            int last = n&1;
            n>>>=1;
            ans += last*base;
            base*=5;
        }
        return ans;

    }

    public static int XORrange(int a){
        if(a%4==0){
            return a;
        }
        if(a%4==1){
            return 1;
        }
        if(a%4==2){
            return a+1;
        }
        return 0;
    }
    public static void PowerOfTwo(int n){
        boolean ans = (n&(n-1))==0;
        System.out.println(ans);
    }
    public static void NoOfDigits(int number, int base){
        System.out.println((int)(Math.log(number)/Math.log(base))+1); // to change the base of the log
    }
    public static void SetBits(int n){
        int count = 0;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(n-3));
        while(n>0){
            count++;
            n-=n&-n;
        }
        System.out.println(count);
    }
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] row : image){
            // reverse this array
            for (int i = 0; i < (image[0].length+1)/2; i++) {
                int temp = row[i]^1;
                row[i] = row[image[0].length-i-1]^1;
                row[image[0].length-i-1] = temp;

            }
        }
        return image;
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        final int targetSum = (rolls.length + n) * mean;
        int missingSum = targetSum - Arrays.stream(rolls).sum();
        if (missingSum > n * 6 || missingSum < n)
            return new int[] {};

        int[] ans = new int[n];
        Arrays.fill(ans, missingSum / n);
        missingSum %= n;
        for (int i = 0; i < missingSum; ++i)
            ++ans[i];

        return ans;
    }

    public static int countSetBits(int n){
        int count = 0;
        while(n>0){
            if((n&1)==1) count++;
            n>>=1;
        }
        return count;
    }

    public static void main(String[] args) {
//        int base = 3;
//        int power = 6;
//        int ans = 1;
//        while(base>0){
//            if((power&1)==1){
//                ans*=base;
//            }
//            base*=base;
//            power>>=1;
//        }
//        System.out.println(ans);

//        System.out.println(countSetBits(0));

        System.out.println(12%2);
    }
}
