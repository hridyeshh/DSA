package Practice;

import java.util.Scanner;

public class InsertAndDelete {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arr1[] = {1,2,3,4,5};
        System.out.println("Enter the number you want to remove : ");
        int n = s.nextInt();
        System.out.println("Enter the number you want to add : ");
        int x = s.nextInt();
        System.out.println("At which position you want to add the number : ");
        int m = s.nextInt();
        for (int i = 0; i < arr1.length; i++) {
            int arr2[] = arr1;
            if(n == arr1[i]){
                continue;
            }
            System.out.print(arr2[i]+" ");
            if(m==i){
                arr1[m] = x;
                int arr3[] = arr1;
                System.out.println(arr3[i]);
            }
        }
    }
}
