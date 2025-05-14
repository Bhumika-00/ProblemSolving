public class recursion1 {
    public static void main(String[] args) {
        numbers(5);
    }
    public static void numbers(int n)
    {
        if(n==0)
        {
            return ;
        }
        System.out.println(n);
        numbers(n-1);
    }
}
