import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        int arr[]={6,8,0,1,3};
        int nextgr[]=new int[arr.length];
        Stack<Integer> s1 = new Stack<>();
        check(arr,nextgr, s1);
        for(int i=0;i<nextgr.length;i++)
        {
            System.out.println(nextgr[i]);
        }
    }
     public static void check(int arr[],int nextgr[],Stack<Integer> s1)
     {
        for(int i=arr.length-1;i>=0;i--)
        {
            int curr= arr[i];
            while(!s1.isEmpty() && curr>=arr[s1.peek()])
            {
                s1.pop();
            }
            if(s1.isEmpty())
            {
                nextgr[i]=-1;
            }
            else{
                 nextgr[i]=arr[s1.peek()];
            }
            s1.push(i);
        }
     }
}
