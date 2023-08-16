package generics.comparing;

import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaFunctions {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            arr.add(i+1);
        }
        //arr.forEach((item)-> System.out.println(item*2));
        // this is a lambda function
        Consumer<Integer> fun = (item) -> System.out.println(item*2);
        arr.forEach(fun);
        Operations sum = (a, b)->a+b;
        Operations minus = (a, b)->a-b;
        Operations product = (a, b)->a*b;
        Operations divide = (a, b)->a/b;

        LambdaFunctions Calculator = new LambdaFunctions();
        System.out.println(Calculator.Operate(3,4,sum));
    }
    private int Operate(int a, int b, Operations op){
        return op.Operations(a,b);
    }
}
interface Operations{
    int Operations(int a, int b);
}