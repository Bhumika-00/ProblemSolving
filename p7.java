import java.util.Stack;

public class p7 {
    public static void main(String[] args) {
        int arr[]={6,8,0,1,3};
        int nextgret[]=new int[arr.length];
        Stack<Integer> s1 = new Stack<>();
        problem(s1, arr, nextgret);
        for(int i=0;i<nextgret.length;i++)
        {
            System.out.println(nextgret[i]);
        }
    }
    public static void problem(Stack<Integer> s1,int arr[],int nextgret[] )
    {
        for(int i=arr.length-1;i>=0;i--)
        {
            int curr= arr[i];
            while (!s1.isEmpty()&& curr>=arr[s1.peek()]) {
                s1.pop();
            }
            if(s1.isEmpty())
            {
                nextgret[i]=-1;
            }
            else
            {
                nextgret[i]=arr[s1.peek()];
            }
            s1.push(i);
        }
    }
}
