import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void main(String[] args) {
         Queue<Integer> q1 = new LinkedList<>();
         for (int i = 1; i <= 10; i++) {
            q1.add(i);
        }
        Stack<Integer> s1 = new Stack<>();
         for (int i = 1; i <= 10; i++) {
            s1.push(q1.remove());
        }
        for (int i = 1; i <= 10; i++) {
           q1.add(s1.pop());
        }
       while (!q1.isEmpty()) {
        System.out.println(q1.peek());
        q1.remove();
       }
        
    }
}
