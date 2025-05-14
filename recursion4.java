public class recursion4 {
    public static void main(String[] args) {
       System.out.println(Sum(5)); 
    }
    public static int Sum(int n)
    {
        if(n==0)
        {
        return 0;
        }
        return n+Sum(n-1);
    }
}
