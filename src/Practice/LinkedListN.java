package Practice;

public class LinkedListN {
    private static Node head;
    private static Node tail;
    private static int size;
    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
        public void insert(int val) {
            Node node = new Node(val);
            node.next = head;
            head = node;
            if(tail == null) {
                tail = head;
            }
            size++;
        }
        public int count() {
            int count = 0;
            while(head != null) {
                count++;
            }
            return count;
        }

    }

    public static void main(String[] args) {
        LinkedListN s = new LinkedListN();

    }
}
