public class StartsAndEndsWithSame {
    public static void main(String[] args) {
        String str = "abcab";
        int n = str.length();
        int i=0;
        int j= str.length()-1;
        System.err.println(verification(str, n, i, j));
    }
    public static int verification(String str , int n , int i , int j)
    {
        if(n==1)
        {
            return 1;
        }
        if(n<=0)
        {
            return 0;
        }
        int res= verification(str, n-1, i+1, j) + verification(str, n-1, i, j-1) - verification(str, n-2, i+1, j-1);
        if(str.charAt(i)==str.charAt(j))
        {
            res = res+1;
        }
        return res;
    }
}
