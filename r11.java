public class r11 {
    public static void main(String[] args) {
        int arr[]={5,6,7,8,9,1,2,3};
        int start = 0;
        int end = arr.length-1;
        int target=1;
        RotatedBinarySearch(arr, start, end, target);

    }
    public static void RotatedBinarySearch(int arr[],int start, int end,int target)
    {
     if(start>end)
     {
        return;
     }
     int mid = (start+end)/2;
     if(arr[mid]==target)
     {
        System.out.println("Found");
     }
    else if(arr[start]<arr[mid])
    {
        if((arr[start]<target) && (target<arr[mid]) )
        {
           RotatedBinarySearch(arr, start, mid-1, target); 
        }
        else
        {
            RotatedBinarySearch(arr, mid+1, end, target);
        }
    }
    else{
        if((arr[mid]<target) && (target<arr[end])){
        RotatedBinarySearch(arr, mid+1, end, target);
        }
        else{
            RotatedBinarySearch(arr, start, mid-1, target); 
        }
    }
    }
}
