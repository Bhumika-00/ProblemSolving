public class PalindromeLL {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public void AddL(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public Node midNode()
    {
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public void printing() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public boolean palindrome()
    {
        if(head==null || head.next==null)
        {
            return true;
        }
        Node curr = midNode();
        Node prev = null;
        Node next;
        while(curr!=null)
        {
           next=curr.next;
           curr.next=prev;
           prev=curr;
           curr=next; 
        }
        Node left = head;
        Node right = prev;
        while(right!=null)
        {
            if(right.data!=left.data)
            {
                return false;
            }
            right=right.next;
            left=left.next;
        }
      return true;

    }
    public static void main(String[] args) {
        PalindromeLL ll = new PalindromeLL();
        ll.AddL(1);
        ll.AddL(2);
        ll.AddL(3);
        ll.AddL(5);
        ll.AddL(2);
        ll.AddL(1);
        System.out.println(ll.palindrome());
       // ll.printing();
    }
}
