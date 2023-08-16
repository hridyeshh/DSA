package Practice;

class linkedlistnode {
    int data;
    linkedlistnode head;
    linkedlistnode next;

    public linkedlistnode() {
        this.data = data;
    }
    public int count() {
        int length = 0;
        while(head.next != null) {
            length++;
        }
        return length;
    }
}



public class Length{
    public static int Length(linkedlistnode head){
        int count = 0;
        while(head.next!=null){
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }

    public void add() {
        linkedlistnode s = new linkedlistnode();
    }
}