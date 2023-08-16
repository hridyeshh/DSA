package generics.comparing;
import generics.CustomArrayList;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Student Rahul = new Student(80, 89.89f);
        Student Hridyesh = new Student(46, 98);
        Student Krish = new Student(67, 93);
        Student Sumit = new Student(86, 96);
        Student[] list = {Rahul,Hridyesh,Krish,Sumit};
        //System.out.println(Arrays.toString(list));
        Arrays.sort(list);
        CustomArrayList s = new CustomArrayList();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        System.out.println(s);
        s.remove(2);
        s.remove(3);
        System.out.println(s);
        //if (Hridyesh.compareTo(Rahul)>0){
           // System.out.println("Rahul has more marks");
            //System.out.println(Hridyesh.compareTo(Rahul));
        //}
    }
}
