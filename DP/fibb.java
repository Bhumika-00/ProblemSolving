public class fibb {
    public static void main(String[] args) {
        int n = 5;
        int f[]=new int[n+1]; //0 to 5
        System.out.println(fibb(n , f));
    }
    public static int fibb(int n , int f[])
    {
        if(n==0 || n==1)
        {
        return n;
        }
        if(f[n]!=0)
        {
            return f[n];
        }
        f[n]= fibb(n-1,f)+fibb(n-2,f);
        return f[n];

    }
}
