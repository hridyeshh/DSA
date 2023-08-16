package generics;
import java.util.ArrayList;
import java.util.Arrays;

public class WildcardExample<T extends Number>{
    private Object [] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public WildcardExample() {
        this.data = new Object[DEFAULT_SIZE];
        //bytecode has no idea of T at the runtime, will be executed at the compile time
    }
    public void add(T num){
        if(isFull()){
            resize();
        }
        data[size++] = num;

    }

    private void resize() {
        Object temp[] = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;

    }

    private boolean isFull() {
        return size == data.length;
    }
    public T remove() {
        T removed = (T)data[--size];
        return removed;
        //will get the last element then
        // print the last value of the array that is removed

    }
    public T get(int index){
        return (T)data[index];
    }
    public int size(){
        return size;
    }
    public void set(int index, int value){
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        //ArrayList list = new ArrayList();
        CustomArrayList list = new CustomArrayList();
//        list.add(3);
//        list.add(5);
//        list.add(9);
        for (int i = 0; i < 14; i++) {
            list.add(2*i);

        }
        System.out.println(list);

        ArrayList<Integer> list2 = new ArrayList<>();
        //<> is Generics
        WildcardExample<Number> list3 = new WildcardExample<>();
        // <String> can't be executed because String is not under Number
        // Quantities bound to Number or subclass of Number, can only be executed
        for (int i = 0; i < 14; i++) {
            list3.add(2*i);
        }
        System.out.println(list2);
    }
}
