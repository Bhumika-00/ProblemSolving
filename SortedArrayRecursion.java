public class SortedArrayRecursion {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,0,6,7,8};
        System.out.println(Sorted(arr , 0));
    }
    public static boolean Sorted(int arr[],int n)
    {
        if(n==arr.length-1)
        {
            return true;
        }
        if(arr[n]<arr[n+1])
        {
          return  Sorted(arr,n+1);
        }
        else{
           return false;
        }
    }
}
