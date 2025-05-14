public class TillingProblem {
    public static void main(String[] args) {
        System.out.println(ways(2));
    }
    public static int ways(int n)
    {
        if(n==0 || n==1)
        {
            return 1;
        }
        return ways(n-1)+ways(n-2);
    }
}
