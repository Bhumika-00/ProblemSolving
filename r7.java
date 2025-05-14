public class r7 {
    public static void main(String[] args) {
        System.out.println(Sum(123));
    }
    public static int Sum(int n)
    {
        if(n==0)
        {
         return 0;
        }
        return n%10+Sum(n/10);
    }
}
