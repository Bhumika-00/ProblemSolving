public class L1 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void add(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addL(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addMiddle(int ind, int data) {
        if (ind == 0) {
            return;
        }
        int i = 0;
        Node temp = head;
        while (i < ind - 1) {
            temp = temp.next;
            i = i + 1;
        }
        Node newNode = new Node(data);
        size++;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeF() {
        Node temp = head;
        head = head.next;
        temp.next = null;
    }

    public void removeL() {
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void removeM(int idx) {
        int i = 0;
        Node temp = head;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        Node handle = temp.next;
        temp.next = temp.next.next;
        handle.next = null;
    }

    public void reverse() {
        Node prev = null;
        Node current = tail = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    public void removeEndN(int idx)
    {  Node prev=head;
        int i=1;
        while(i<size-idx)
        {
         prev = prev.next;
         i++;
        }
        Node temp = prev.next;
        prev.next=temp.next;
        temp.next=null;
    }
    public void printing() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        L1 ll = new L1();
        ll.addL(1); // Adds at end
        ll.addL(2);
        ll.addL(3);
        ll.add(0); // Adds at beginning
        ll.addL(4);
        ll.addL(5);
        ll.addL(6);
        // ll.removeF();
        // ll.removeL();
        // ll.addMiddle(2,11); // Adds at end
        // ll.removeM(2);
        // ll.reverse();
        ll.removeEndN(3);
        ll.printing();
        // System.out.println(size);

    }
}
