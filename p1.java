import java.util.ArrayList;

public class p1 {
    public static class Stack{
        ArrayList<Integer> list = new ArrayList<>();
        public boolean isEmpty()
        {
            return list.size()==0;
        }
        public void push(int data)
        {
        list.add(data);
        }
        public int pop()
        {
            if(list.size()==0)
            {
                System.out.println("Nothing to print");
                return -1;
            }
            int top = list.remove(list.size()-1);
            return top;
        }
        public int peek()
        {
            if(list.size()==0)
            {
                System.out.println("Nothing to print");
                return -1;
            }
            int top = list.get(list.size()-1);
            return top;
        }
    }
    public static void main(String[] args) {
        Stack s1 = new Stack();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        while(!s1.isEmpty())
        {
            System.out.println(s1.peek());
            s1.pop();
        }
    }
}
