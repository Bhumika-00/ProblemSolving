import java.util.Stack;

public class p6 {
    public static void main(String[] args) {
        int stocks[]={100,80,60,70,60,85,100};
        int span[]= new int[stocks.length];
        Stack<Integer> s1 = new Stack<>();
        problem(stocks, span, s1);
        for(int i=0;i<span.length;i++)
        {
            System.out.println(span[i]);
        }

    }
    public static void problem(int stocks[],int span[],Stack<Integer> s1)
    {
        span[0]=1;
        s1.push(0);
        for(int i=1;i<stocks.length;i++)
        {
            int curr= stocks[i];
            while(!s1.isEmpty() && curr>=stocks[s1.peek()])
            {
                s1.pop();
            }
            if(s1.isEmpty())
            {
                span[i]=i+1;
            }
            else
            {
                span[i]=i-s1.peek();
            }
            s1.push(i);
        }
    }
}
