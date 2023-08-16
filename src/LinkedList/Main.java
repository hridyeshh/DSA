package LinkedList;

public class Main {
    public static void main(String[] args) {
        LL s = new LL();
        s.insertFirst(1);
        s.insertFirst(2);
        s.insertFirst(3);
        s.insertFirst(4);
        s.insertFirst(5);
        s.insertRec(12,2);
        s.insertRec(34,4);
        s.display();
        System.out.println(s.Length());
    }
}
