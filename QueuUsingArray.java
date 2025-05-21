public class QueuUsingArray {
    public static class Queue{
        int arr[];
        int size;
        int rear;
        Queue(int n)
        {
            arr=new int[n];
            size=n;
            rear=-1;
        }
        public boolean isEmpty()
        {
            return rear==-1;
        }
        public void enqueue(int data)
        {
            if(rear==size-1)
            {
                System.out.println("Full");
                return;
            }
            rear=rear+1;
            arr[rear]=data;
        }
        public int dequeue()
        {
            if(rear==-1)
            {
               System.out.println("Nothing to put");
                return -1; 
            }
            int front=arr[0];
            for(int i=0;i<rear;i++)
            {
                arr[i]=arr[i+1];
            }
            rear=rear-1;
            return front;
        }
        public int peek()
        {
            if(rear==-1)
            {
               System.out.println("Nothing to put");
                return -1; 
            }
             int front=arr[0];
              return front;
        }
    }

    public static void main(String[] args) {
        Queue q1 = new Queue(5);
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        while (!q1.isEmpty()) {
            System.out.println(q1.peek());
            q1.dequeue();
        }
    }
}
