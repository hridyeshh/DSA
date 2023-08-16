package Practice;

public abstract class duplicateNum {
    public static void main(String[] args) {
        int arr2[];
        int arr[] = {1,2,1,2,3,4,4,5,5};
        System.out.println(isPrime(arr));
//        for (int i = 0; i < 6; i++) {
//            arr[i]=i+2;
//            System.out.println(arr[i]);
//        }
    }
    public static boolean isPrime(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            if((arr[i]^arr[i])==0) {
                System.out.println(arr[i]);
                return true;
            }

            else{
                return false;
            }
        }
        return true;
    }
    public int Make(int num){
        System.out.println(num);
        return num;
    }
}
