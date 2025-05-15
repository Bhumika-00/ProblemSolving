public class BacktrackingOnArrays {
    public static void main(String[] args) {
        int arr[]=new int[5];
        int i=0;
        int num=1;
        backtrack(arr, i, num);
        for( i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
    public static void backtrack(int arr[] , int i ,int num)
    {
       if(i==arr.length)
       {
        return ;
       }
       arr[i]=num;
       backtrack(arr, i+1, num+1);
       arr[i] = arr[i]-2;

    }
}
