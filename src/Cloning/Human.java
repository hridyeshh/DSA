package Cloning;

public class Human {
    int age;
    String name;
    int arr[];

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr  = new int[]{3,4,5};
    }
    public Human(Human other){
        this.age = other.age;
        this.name = other.name;
    }
    @Override // clone method is being overridden from the object class
    protected Object clone() throws CloneNotSupportedException{
        Human twin = (Human)super.clone();
        twin.arr = new int[twin.arr.length];
        for (int i = 0; i < twin.arr.length; i++) {
            twin.arr[i] = this.arr[i];
        }
        return twin;
    }
}
