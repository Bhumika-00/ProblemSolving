import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueUsingTwoStacks {
    public static class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        public boolean isEmpty()
        {
            return s1.isEmpty();
        }
        public void enqueue(int data) {
            if (s1.isEmpty()) {
                s1.push(data);
            }
            else{
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                s1.push(data);
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
        }
        public int dequeue()
        {
            return s1.pop();
        }
        public int peek()
        {
            return s1.peek();
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
