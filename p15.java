import java.util.LinkedList;
import java.util.Queue;

public class p15 {
   public static void main(String[] args) {
    Queue<Integer> q1 = new LinkedList<>();
    q1.add(1);
    q1.add(2);
     while (!q1.isEmpty()) {
            System.out.println(q1.peek());
            q1.remove();
        }
   } 
}
