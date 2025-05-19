import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int stocks[]={100,80,60,70,60,85,100};
        int span[]=new int[stocks.length];
        Stack<Integer> s1 = new Stack<>();
        check(stocks, span, s1);
        for(int i=0;i<span.length;i++)
        {
            System.out.println(span[i]);
        }
    }
    public static void check(int stocks[],int span[],Stack<Integer> s)
    {
    span[0]=1;
    s.push(0);
    for(int i=1;i<stocks.length;i++)
    {
        int curr = stocks[i];
        while(!s.isEmpty() && curr>stocks[s.peek()])
        {
            s.pop();
        }
        if(s.isEmpty())
        {
            span[i]=i+1;
        }
        else{
            span[i]=i-s.peek();
        }
        s.push(i);
    }
    }
}
