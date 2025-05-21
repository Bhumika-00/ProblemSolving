import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s1 = "{[](){([])}}"; // valid, no duplicate
        String s2 = "((a+b))";      // valid, duplicate parentheses around (a+b)
        String s3 = "((a+b)+c)";    // valid, no duplicate parentheses
        String s4 = "((()))";       // valid, duplicate parentheses

        System.out.println("Input: " + s1);
        System.out.println("Valid: " + check(s1));
        System.out.println("Has Redundant Parentheses: " + hasRedundantParentheses(s1));
        System.out.println();

        System.out.println("Input: " + s2);
        System.out.println("Valid: " + check(s2));
        System.out.println("Has Redundant Parentheses: " + hasRedundantParentheses(s2));
        System.out.println();

        System.out.println("Input: " + s3);
        System.out.println("Valid: " + check(s3));
        System.out.println("Has Redundant Parentheses: " + hasRedundantParentheses(s3));
        System.out.println();

        System.out.println("Input: " + s4);
        System.out.println("Valid: " + check(s4));
        System.out.println("Has Redundant Parentheses: " + hasRedundantParentheses(s4));
    }

    // Checks if parentheses are balanced and valid
    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (currChar == '{' || currChar == '[' || currChar == '(')
            {
                stack.push(currChar);
            } else if (currChar == '}' || currChar == ']' || currChar == ')')
            {
                if (stack.isEmpty()) 
                {
                    return false;
                }

                char top = stack.peek();
                if ((currChar == ')' && top == '(') ||
                    (currChar == ']' && top == '[') ||
                    (currChar == '}' && top == '{')) 
                {
                    stack.pop();
                } 
                else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    // Detects duplicate or redundant parentheses (only round brackets)
    public static boolean hasRedundantParentheses(String expr) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expr.toCharArray()) {
            if (ch == ')') 
            {
                int count = 0;

                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                    count++;
                }

                if (stack.isEmpty()) {
                    return false; // no matching '(' found, so not valid
                }

                stack.pop(); // pop the matching '('

                if (count <= 1) {
                    // If no or only one character inside parentheses, it's redundant
                    return true;
                }
            }
             else {
                stack.push(ch);
            }
        }

        return false;
    }
}
