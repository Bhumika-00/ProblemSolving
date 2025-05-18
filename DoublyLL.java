public class DoublyLL {
    public static class Node{
        Node prev;
        int data;
        Node next;
        public Node(int data)
        {
            this.prev=null;
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void AddF(int data)
    {  
        Node newNode = new Node(data);
        size=size+1;
        if(head == null)
        {
        head=tail=newNode;
        return;
        }
        newNode.next=head;
        newNode.prev=null;
        head=newNode;
    }
    public void AddL(int data)
    {  
        Node newNode = new Node(data);
        size=size+1;
        if(head == null)
        {
        head=tail=newNode;
        return;
        }
       newNode.prev=tail;
       tail.next=newNode;
       tail=newNode;
    }
    public void AddM(int data , int idx)
    {  
        int i=0;
        Node temp =head;
        while(i<idx-1)
        {
            temp=temp.next;
            i++;
        }
        Node handle = temp.next;
        Node newNode = new Node(data);
        newNode.next=temp.next;
        newNode.prev=temp;
        temp.next=newNode;
        handle.prev=newNode;
        
    }
    public void printing()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        DoublyLL ll = new DoublyLL();
        ll.AddF(2);
        ll.AddF(1);
        ll.AddL(4);
        ll.AddL(5);
        ll.AddM(3, 2);
        ll.printing();
    }
}
