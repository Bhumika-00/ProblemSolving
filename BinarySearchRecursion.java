public class BinarySearchRecursion {
    public static void main(String[] args) {
        int arr[]={1,2,9,10,11,12,13,14};
        int key = 12;
        int start =0;
        int end = arr.length-1;
        System.out.println(BinarySearch(arr , key , start , end));
    }
    public static int BinarySearch(int arr[] ,int key , int start , int end)
    {
        if(start>end)
        {
            return -1;
        }
        int mid = (start+end)/2;
        if(key == arr[mid])
        {
            return mid;
        }
        else if(key > arr[mid])
        {
        return  BinarySearch(arr , key , mid+1 , end);

        }
        else{
         return   BinarySearch(arr , key , start , mid-1);
        }
    }
}
