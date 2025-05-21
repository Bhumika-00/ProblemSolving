import java.util.Stack;

public class p3 {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);
        int data = 45;
        pushAtBottom(s1, data);
        while(!s1.isEmpty())
        {
         System.out.println(s1.peek());
         s1.pop();
        }
    }
    public static void pushAtBottom(Stack<Integer> s1 , int data)
    {
        if(s1.empty())
        {
        s1.push(data);
        return;
        }
        int top = s1.pop();
        pushAtBottom(s1, data);
        s1.push(top);
    }
}
