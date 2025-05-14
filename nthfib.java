public class nthfib {
    public static void main(String[] args) {
        int n= 6;
        int ans = fibb(n);
        System.out.println(ans);
    }
    public  static  int fibb(int n)
    {
        if(n<=1)
        {
            return n;
        }
       return fibb(n-1) + fibb(n-2);
    }
}
