package Practice;

public class MaximumBags {
    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] arr = new int[additionalRocks];
        int i = 0;
        int maximumBags = 0;
        for(i = 0; i < arr.length; i++) arr[i] = 1;
        while(capacity[i]>rocks[i]){
            if(rocks[i]+arr[i]==capacity[i]) maximumBags++;
        }
        return maximumBags;
    }

    public static void main(String[] args) {
        int[] capacity = {2,3,4,5};
        int[] rock = {1,2,4,4};
        int additionalRocks = 2;
        System.out.println(maximumBags(capacity,rock,additionalRocks));
    }
}
