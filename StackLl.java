import java.util.Stack;

public class StackLl {
    public static class Node{
        int data;
        Node next;
        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    public static class Stack{
     Node head = null;
     Node tail = null;
     public boolean isEmpty()
     {
        return head==null;
     }
     public void push(int data)
     {
        Node newnNode= new Node(data);
       if(head==null)
       {
       head=tail=newnNode;
       }
      newnNode.next=head;
      head=newnNode;
     }
     public int pop()
     {
        Node temp = head;
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
        Stack s1 = new Stack(); // Use the inner class Stack
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);

        while (!s1.isEmpty()) {
            System.out.println(s1.peek());
            s1.pop();
        }
    }
}
