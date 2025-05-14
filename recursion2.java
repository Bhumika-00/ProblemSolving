public class recursion2 {
    public static void main(String[] args) {
        numbers(5);
    }
    public static void numbers(int n)
    {
        if(n==0)
        {
           return ; 
        }
        numbers(n-1);
        System.out.println(n);

    }
}
