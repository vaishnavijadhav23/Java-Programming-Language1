
public class LinkedList2 {

    public static class Node {
        int data;
        Node next;

        public Node(int data){

            this.data = data;
            this.next = null;
        }
    }
    public static Node head;

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
         
    }

    public static void removeCycle() {
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean Cycle = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
               Cycle = true;
               break; 
            }
        }
        if(Cycle == false) {
                return;
        }
        //find meeting point
        slow  = head;
        Node prev = null; //last node
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;   
        }
        //remove cycle -> last.next = null
        prev.next = null;
        
    }
    public static void main(String[] args) {
        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = head;
        //1->2->3->1

        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
        
    }
    
}
