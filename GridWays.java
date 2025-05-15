public class GridWays {
    public static void main(String[] args) {
        int m =3;
        int n=3;
        int grid[][]=new int[m][n];
        int i=0;
        int j=0;
        System.err.println(ways(m, n, grid, i, j));
    }
    public static int ways(int m ,int n , int grid[][], int i , int j)
    {
        if(i==n-1 && j==m-1)
        {
            return 1;
        }
        if(i==n || j==m)
        {
             return 0;
        }
        return ways(m, n, grid, i+1, j)+ways(m, n, grid, i, j+1);
    }
}
