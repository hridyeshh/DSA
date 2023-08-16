package Cloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException{
        Human Hridyesh = new Human(18, "Hridyesh");
        Human twin = (Human) Hridyesh.clone();
        System.out.println(twin.age +" "+twin.name);
        System.out.println(Arrays.toString(twin.arr));
        twin.arr [0]=100;
        System.out.println(Arrays.toString(twin.arr));
        System.out.println(Arrays.toString(Hridyesh.arr));
    }
}
