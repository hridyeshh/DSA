package Practice;

import java.util.*;

public class gfg {
    public static int doUnion(int a[], int n, int b[], int m) {
        Set<Integer> unionSet = new HashSet<>();
        for (int i = 0; i < n; i++) unionSet.add(a[i]);
        for (int i = 0; i < m; i++) unionSet.add(b[i]);
        return unionSet.size();
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
    }
}
