import java.util.Stack;

public class p11 {
    public static void main(String[] args) {
        String str = "((()))";
       System.out.println(duplicateParenthesis(str));
    }
    public static boolean duplicateParenthesis(String str)
    {int count;
     Stack<Character> s1 = new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char currChar = str.charAt(i);
            if(currChar==')')
            {
                count=0;
                while (!s1.isEmpty() && s1.peek()!='(') {
                    count=count+1;
                    s1.pop();
                }
                if(s1.isEmpty())
                {
                    return false;
                }
                s1.pop();
               if(count<=1)
               {
                return true;
               } 
            }
            else{
                s1.push(currChar);
            }
        }
        return false;
    }
}
