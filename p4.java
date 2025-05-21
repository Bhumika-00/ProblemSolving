import java.util.Stack;

public class p4 {
    public static void main(String[] args) {
        String str = "abcd";
        reverse(str);
    }
    public static void reverse(String str)
    {
        Stack<Character> s1 = new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            s1.push(str.charAt(i));
        }
        while(!s1.isEmpty())
        {
            System.out.print(s1.peek());
            s1.pop();
        }
    }
}
