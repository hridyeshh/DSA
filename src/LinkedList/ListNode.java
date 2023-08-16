package LinkedList;
class listNode {
    int val;
    listNode next;

    public listNode() {
    }

    listNode(int x) {
        val = x;
        next = null;
    }
    public boolean isHappy(int n){
        int slow = n;
        int fast = n;
        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow != fast);
        if(slow==1){
            return true;
        }
        return false;
    }
    public int lengthCycle(listNode head) {
        listNode fast = head;
        listNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // calculate the length
                listNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }
    public listNode detectCycle(listNode head){
        int length = 0;
        listNode fast = head;
        listNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        // find the start node
        listNode f = head;
        listNode s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        // keep moving both forward and they will meet at cycle start
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }
    private int findSquare(int number){
        int ans = 0;
        while(number > 0){
            int rem = number%10;
            ans += rem*rem;
            number /= 10;
        }
        return ans;
    }
}
