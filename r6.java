public class r6 {
    public static void main(String[] args) {
        int arr[]={1,8,9,99,101};
        int end=arr.length-1;
        int start = 0;
int key =59;
System.out.println(BinarySearch(arr, end, start, key));
    }
    public static boolean BinarySearch(int arr[],int end , int start,int key)
    {
        if(start>=end)
        {
            return false;
        }
        int mid=(start+end)/2;
        if(arr[mid]==key)
        {
            return true;
        }
        else if(arr[mid]>key)
        {
            return BinarySearch(arr, end ,mid+1, key);
        }
        return BinarySearch(arr, mid-1 ,start, key);
    }
}
