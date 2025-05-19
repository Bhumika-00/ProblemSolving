import java.util.Stack;

public class PushAtBottom {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        int data=45;
        reverse(s1);
       while (!s1.empty()) {

            System.out.println(s1.pop());
        }
    }
    public static void atBottom(Stack<Integer> s1 ,int data)
    {
        if(s1.isEmpty())
        {
            s1.push(data);
            return;
        }
       int top= s1.pop();
        atBottom(s1, data);
        s1.push(top);
    }
    public static void reverse(Stack<Integer> s1)
    {
        if(s1.isEmpty())
        {
           
            return;
        }
         int top= s1.pop();
         reverse(s1);
         atBottom(s1,top);
    }
}
