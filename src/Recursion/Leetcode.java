package Recursion;
import java.util.*;
public class Leetcode {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0]<rec2[2] && rec2[0]<rec1[2] && rec1[1]<rec2[3] && rec2[1]<rec1[3];
    }

    public static void permutationSet(int[] nums, int index, List<Integer> set, List<List<Integer>> finalList) {
        if(set.size()==nums.length){
            finalList.add(new ArrayList<>(set));
            return;
        }

    }

    static int[] getCumulativeSum (int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i]+arr[i-1];
        }
        return arr;
    }

    static List<Integer> getPositiveCumulativeSum (int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i]+arr[i-1];
            if(arr[i]>0) {
                list.add(arr[i]);
            }
        }
        return list;
    }

    static int count_like_dislike(String A, String P){
        int result = 0;
        int bitmaskBob = Integer.parseInt(A, 2);
        int bitmaskAlice = Integer.parseInt(P, 2);
        int commonTopics = bitmaskBob & bitmaskAlice;

        while (commonTopics > 0) {
            if ((commonTopics & 1) == 1) {
                result++;
            }
            commonTopics >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] rec1 = {5,15,8,18};
        int[] rec2 = {0,3,7,9};
//        System.out.println(isRectangleOverlap(rec1,rec2));
        int[] arr = {5,1,-1,-1,-1,1};
//        System.out.println(Arrays.toString(getCumulativeSum(arr)));
//        System.out.println(getPositiveCumulativeSum(arr));

//        System.out.println(count_like_dislike("000100","111111"));
        System.out.println();
    }
}
