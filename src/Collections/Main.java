package Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        list.add(45);
        list.add(54);
        list.add(89);
        System.out.println(list);
        list.clear(); // to clear the elements in a list, we use clear method
        System.out.println(list);

        List<Integer> vector = new Vector<>();
        vector.add(43);
        vector.add(52);
        System.out.println(vector);
    }
}
