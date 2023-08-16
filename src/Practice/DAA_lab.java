package Practice;

public class DAA_lab {
    public static int KoiMilGya(int val) {
        int output = 0;
        while (val != 0) {
            output += val % 10;
            val /= 10;
            int arr[]=new int[10];
            for (int i = 0; i < arr.length; i++) {

            }

        }
        return output;
    }
    public static void minimumNum(int number) {
        int i = 0;
        while (true) {
            if (KoiMilGya(i) == number) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }
    public int add(int input[], int num){
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum+=input[i];
        }
        return num;
    }
    public static void bubbleSort(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            for(int j = i; j < arr.length-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+ 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.print("Sorted array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
    // Java program to find the number
// of ways to distribute N item
// among three people such
// that one person always gets
// the maximum value

        // Function to find the number
// of ways to distribute N
// items among 3 people
        static int countWays(int N)
        {
            // No distribution
            // possible
            if (N < 4)
                return 0;

            // Total number of ways to
            // distribute N items
            // among 3 people
            int ans = ((N - 1) * (N - 2)) / 2;

            // Store the number of
            // distributions which
            // are not possible
            int s = 0;

            for (int i = 2; i <= N - 3; i++)
            {
                for (int j = 1; j < i; j++)
                {

                    // Count possibilities
                    // of two persons
                    // receiving the
                    // maximum
                    if (N == 2 * i + j)
                        s++;
                }
            }

            // If N is divisible by 3
            if (N % 3 == 0)
                s = 3 * s + 1;
            else
                s = 3 * s;

            // Return the final
            // count of ways
            // to distribute
            return ans - s;
        }

        // Driver Code

// This code is contributed by rock_cool

    public static void strictlyMax(int arr[], int a) {
        int i = 0;
        int temp[] = new int[arr.length];
        while (arr[i] < a) {
            temp[i] = arr[i];
            i++;
        }
        System.out.println(temp[temp.length-i]);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,7,6,8};
        bubbleSort(arr);
        System.out.println();
        strictlyMax(arr,8);

    }
}

