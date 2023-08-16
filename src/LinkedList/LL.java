package LinkedList;

public class LL {
    private static Node head; // this head is a class itself that has a value and the reference to the next node
    private static Node tail;
    private int size;

    public LL() {
        this.size=0;
    }
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail==null){
            tail = head;
        }
        size+=1;
    }
    public void insertLast(int val) {
            if(tail==null){
                insertFirst(val);
                return;
            }
            Node node = new Node(val);
            tail.next = node;
            tail = node;
            size++;
    }
    public void insert(int val,int index){
        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size){
            insertLast(val);
            return;
        }
        Node temp = head; // pointing the head of the LinkedList
        for (int i = 1; i < index; i++) { // going from 2nd position as first is the head itself to index-1 position
            temp = temp.next; //pointing to next node after temp
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;
    }
    // insert using recursion
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }
    private Node insertRec(int val, int index, Node node) { // node represent the current node
        if (index == 0) { // if index is zero that means at when we reach the node where we want to insert the node
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index-1, node.next); // insertRec() will create a node of the value we need with the index we said referring the current node and node.next node will tell the next node after the node we created
        return node;
    }
    public int deleteFirst(){
        if(tail==null){
            tail = head;
        }
        int value = head.value;
        head = head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return value;
    }
    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        Node secondLast = get(size-2); // pointing to second last element
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }
    public int delete(int index){
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
        Node prev = get(index-1); // this will get us the node just previous than the node we want to remove
        int val = prev.next.value; // this will get the value of the node that is going to be removed
        prev.next = prev.next.next; // this will remove the node we wanted from the chain thus breaking the chain and removing the element from the linked-list
        return val;
    }
    public Node find(int value){
        Node node = head;
        while(node!=null){
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next; // will point the node and return the value at that index
        }
        return node;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value +" --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public static int Length(){
        Node temp = head;
        int count = 0;
        if(head.next == null){
            return 1;
        }
        if(head == null){
            return -1;
        }
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public int LengthCycle(Node head){
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                Node temp = slow;
                int length = 0;
                do{
                    temp = temp.next;
                    length++;
                }while(temp!=slow);
                return length;
            }
        }
        return 0;
    }
    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node() {
            this.value = value;
        }
    }
    public void duplicate(){
        Node node = head;
        while(node.next!=null){
            if(node.value == node.next.value){
                node.next = node.next.next;
                size--;
            }
            else{
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }
    public static LL merge(LL first, LL second) {
        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();

        while (f != null && s != null) {
            if (f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }

        return ans;
    }

    public static void main(String[] args) {
        LL first = new LL();
        LL second = new LL();
        first.insertLast(1);
        first.insertLast(3);
        first.insertLast(5);


        second.insertLast(1);
        second.insertLast(2);
        second.insertLast(9);
        second.insertLast(14);

        LL ans = LL.merge(first, second);
        ans.display();

    }
}

