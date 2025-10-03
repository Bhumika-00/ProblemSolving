public class pracLL {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node head;
    public static Node tail;

    public static void insertFirst(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = tail = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }
    }
    public static void insertLast(int data) {
    Node newnode = new Node(data);
    if (head == null) {
        head = tail = newnode;
    } else {
        tail.next = newnode; 
        tail = newnode;      
    }
}

    public static void printing() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {
        insertFirst(0);
        insertFirst(1);
        insertFirst(2);
        insertLast(3);
        insertLast(4);
        printing();
    }
}
