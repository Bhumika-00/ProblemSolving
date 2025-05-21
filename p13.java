import java.util.Queue;

public class p13 {
   public static class Queue{
    int arr[];
    int size;
    int rear;
    int front;
    Queue(int n)
    {
        arr=new int[n];
        size=n;
        rear=-1;
        front=-1;
    }
    public boolean isEmpty()
    {
        return((rear==-1)&&(front==-1));
    }
    public boolean isFull()
    {
        return ((rear+1)%size==front);
    }
    public void enqueue(int data)
    {
        if(isFull())
        {
            System.out.println("Alraedy Full");
            return;
        }
        if(front==-1)
        {
            front=front+1;
        }
        rear=(rear+1)%size;
        arr[rear]=data;
    }
    public int dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Nothing to print");
            return -1;
        }
       int result = arr[front];
        if(front==rear)
        {
            front=rear=-1;
        }
        else{
            front = (front+1)%size;
        }
        return result;
    }
    public int peek()
    {
         if(isEmpty())
        {
            System.out.println("Nothing to print");
            return -1;
        }
       int result = arr[front];
        return result;
    }
   }

    public static void main(String[] args) {
        Queue q1 = new Queue(6);
        q1.enqueue(1);
        q1.enqueue(2);
        while (!q1.isEmpty()) {
            System.out.println(q1.peek());
            q1.dequeue();
        }
    }
}
