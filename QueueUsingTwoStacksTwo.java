import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class QueueUsingTwoStacksTwo {
    
public static class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        public boolean isEmpty()
        {
            return s1.isEmpty();
        }
        public void enqueue(int data) {
            s1.push(data);
        }
        public int dequeue()
        { int top;
           if(s1.empty())
           {
             return -1;
           }
           else
           {
             while (!s1.isEmpty()) {
                s2.push(s1.pop());
             }
             top = s2.pop();
             while (!s2.isEmpty()) {
                s1.push(s2.pop());
             }
           }
           return top;
        }
        public int peek()
        {
           int top;
           if(s1.empty())
           {
             return -1;
           }
           else
           {
             while (!s1.isEmpty()) {
                s2.push(s1.pop());
             }
             top = s2.peek();
             while (!s2.isEmpty()) {
                s1.push(s2.pop());
             }
           }
           return top;
        }
    }

    public static void main(String[] args) {
        Queue q1 = new Queue();
        q1.enqueue(1);
        q1.enqueue(2);
         q1.enqueue(3);
          q1.enqueue(4);
          while (!q1.isEmpty()) {
            System.out.println(q1.peek());
            q1.dequeue();
          }
        
    }
}

