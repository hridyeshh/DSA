package Graph;
import java.util.*;
class item{
    int value, weight;
    item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class KnapSack {
    double KnapSack(int w, item[] arr, int n){
        Arrays.sort(arr, new itemComparator());
        int curWeight = 0;
        double finalValue = 0;
        for (int i = 0; i < n; i++) {
            if(curWeight+arr[i].weight<=w){
                curWeight += arr[i].weight;
                finalValue += arr[i].value;
            }
            else{
                int remain = w-curWeight;
                finalValue += (double)((arr[i].value/arr[i].weight) * remain);
                break;
            }
        }
        return finalValue;
    }
}
