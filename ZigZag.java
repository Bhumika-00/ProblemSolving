public class ZigZag {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;

    // Add node to the end
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    // Print the linked list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void zigZag() {
        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node miNode = slow;
        Node prev = null;
        Node curr = miNode.next;
        miNode.next = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node lhead = head;
        Node rhead = prev;
        Node LN;
        Node RN;
        while (rhead != null && lhead != null) {
            LN = lhead.next;
            lhead.next = rhead;
            RN = rhead.next;
            rhead.next = LN;
            lhead = LN;
            rhead = RN;
        }
    }

    public static void main(String[] args) {
        ZigZag list = new ZigZag();

        list.add(4);
        list.add(2);
        list.add(1);
        list.add(3);
        list.print();
        list.zigZag();
        list.print();
    }
}
