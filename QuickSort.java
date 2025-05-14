public class QuickSort {
    public static void main(String[] args) {
        int arr[]={6,3,9,8,2,5};
        int start = 0;
        int end = arr.length-1;
        quick(arr, start, end);
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
    public static void quick(int arr[] , int start , int end)
    {
    if(start<end)
    {
        int pivotindex = pivot(arr, start, end);
        quick(arr, start, pivotindex-1);
        quick(arr, pivotindex+1, end);
    }
    
    }
    public static int pivot(int arr[] , int start , int end)
    {
    int i=start-1;
    int pivotele = arr[end];
    int temp;
    for(int j=start;j<=end;j++)
    {
        if(arr[j]<pivotele)
        {
            i++;
            temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
    i++;
    temp = arr[i];
            arr[i]=arr[end];
            arr[end]=temp;
    return i;
    }
    
}
