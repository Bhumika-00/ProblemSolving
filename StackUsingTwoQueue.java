import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueue {
    public static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public int pop() {
            if (isEmpty()) return -1;
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) break;
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) break;
                    q1.add(top);
                }
            }
            return top;
        }

        public int peek() {
            if (isEmpty()) return -1;
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.peek()); // 30
        System.out.println(s.pop());  // 30
        System.out.println(s.peek()); // 20
        s.push(40);
        System.out.println(s.pop());  // 40
        System.out.println(s.pop());  // 20
        System.out.println(s.pop());  // 10
        System.out.println(s.pop());  // -1 (stack is empty)
    }
}
