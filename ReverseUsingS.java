import java.util.Stack;

public class ReverseUsingS {
    public static void main(String[] args) {
        Stack<Character> s1 = new Stack<>();
        s1.push('a');
        s1.push('b');
        s1.push('c');
        
       
       while (!s1.empty()) {

            System.out.print(s1.pop());
        }
    }
   
}
