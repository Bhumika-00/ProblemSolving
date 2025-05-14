public class recursion5 {
    public static void main(String[] args) {
     System.out.println(fibb(7));
    }
    public static int fibb(int n)
    {
        if(n==1 || n==2)
        {
            return 1;
        }
        return fibb(n-1)+fibb(n-2);
    }
}
