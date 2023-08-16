package LinkedList;

public class DL {
    private Node head;
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }
    public void display(){
        Node node = head;
        Node last = null;
        while (node != null) {
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");
        System.out.println("Print in reverse");
        while(last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }
    public void insertLast(int val) {
        Node node = new Node(val);
        Node last = head;

        node.next = null;

        if(head==null){
            node.prev = null;
            head = node;
            return;
        }
        while(last.next != null){
            last=last.next;
        }
        last.next = node;
        node.prev = last;

    }
    public Node find(int value){
        Node node = head;
        while(node!=null){
            if(node.val==value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insert(int after, int val) {
        Node p = find(after);
        if(p==null){
            System.out.println("Does not exist");
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p; // making the double linked list here
        // by connecting it to the previous node too
        if(node.next!=null){
            node.next.prev = node;
        }
    }
    public class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

}
