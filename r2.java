public class r2 {
    public static void main(String[] args) {
        count(5);
    }
    public static void count(int n)
    {
        if(n==0)
        {
            return ;
        }
        count(n-1);
        System.out.println(n);
    }
}
