public class Cycle {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public void detectAndRemoveCycle() {
        Node slow = head;
        Node fast = head;
        boolean hasCycle = false;

        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) return;

        // Remove cycle
        slow = head;

        if (slow == fast) {
            // Special case: cycle starts at head
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
        } else {
            // General case
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
    }

    public void printList() {
        Node temp = head;
        int limit = 100; // Safety to prevent infinite loop
        while (temp != null && limit-- > 0) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Cycle c1 = new Cycle();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head; // Creates cycle at head

        c1.detectAndRemoveCycle();
        c1.printList(); // Output should be: 1 2 3
    }
}
