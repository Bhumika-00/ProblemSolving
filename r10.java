public class r10 {
    public static void main(String[] args) {
        int arr[]={1,2,4,6,99,9,12};
        int n = 0;
        System.out.println(sorted(arr, n));
    }
    public static boolean sorted(int arr[] , int n)
    {
        if(n==arr.length-1)
        {
          return true;  
        }
        return(arr[n]<arr[n+1])&&sorted(arr, n+1);
    }
}
