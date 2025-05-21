public class p14 {
    public static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            this.next=next;
        }

    }
    public static class Queue{
        Node head = null;
        Node tail= null;
        public boolean isEmpty()
        {
            return head==null;
        }
        public void enqueue(int data)
        {
            Node newNode = new Node(data);
            if(head==null)
            {
                head=tail=newNode;
            }
            tail.next=newNode;
            tail=newNode;
        }
        public int dequeue()
        {
            if(head==tail)
            {
                head=tail=null;
                return -1;
            }
            Node temp=head;
            head=head.next;
            temp.next=null;
           return temp.data;
        }
        public int peek()
        {
            return head.data;
        }
    }
    public static void main(String[] args) {
        Queue q1 = new Queue();
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        while (!q1.isEmpty()) {
            System.out.println(q1.peek());
            q1.dequeue();
        }
    }
}
