public class p2 {
    public static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    public static class Stack{
       Node head = null;

        public boolean isEmpty()
        {
            return head==null;
        }
        public void push(int data)
        {
            Node newnNode = new Node(data);
            if(head==null)
            {
                head = newnNode;
                return;
            }
            newnNode.next=head;
            head=newnNode;
        }
        public int pop()
        {
            if(head==null)
           {
            return -1;
           }
           Node temp = head;
           head=head.next;
           temp.next=null;
           return temp.data;
        }
        public int peek()
        {
             if(head==null)
           {
            return -1;
           }
            Node temp = head;
             return temp.data;
        }
    }
    public static void main(String[] args) {
        Stack s1 = new Stack();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        while (!s1.isEmpty()) {
            System.out.println(s1.peek());
            s1.pop();
        }
    }
}
