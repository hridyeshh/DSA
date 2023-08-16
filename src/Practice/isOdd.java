package Practice;

public class isOdd {
    public static void main(String[] args) {
        int n = 55;
        System.out.println(isOdd(n));

        int arr[] = {1,2,2,3,4,5,5,6,4,1,6};
        System.out.println(different(arr));
    }

    public static boolean isOdd(int num) {

        return (num & 1) == 1;
    }

    public static int different(int arr[]) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        return res;
    }
}
