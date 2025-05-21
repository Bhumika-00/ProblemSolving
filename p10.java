import java.util.Stack;

public class p10 {
    public static void main(String[] args) {
        String str="{{[]}({[]()})}";
        System.out.println(validParenthesis(str));
    }
    public static boolean validParenthesis(String str)
    {
        Stack<Character> s1 = new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char currChar = str.charAt(i);
            if((currChar=='(')||(currChar=='{')||(currChar=='['))
            {
                s1.push(currChar);

            }
            else if((currChar==')')||(currChar=='}')||(currChar==']'))
            {
                if(s1.isEmpty())
                {
                    return false;
                }
                char top = s1.peek();
                if ((currChar == ')' && top == '(') ||
                    (currChar == ']' && top == '[') ||
                    (currChar == '}' && top == '{')) {
                    s1.pop();
                }
                else{
                   return false; 
                }
            }
        }
        return s1.isEmpty();
    }
}
