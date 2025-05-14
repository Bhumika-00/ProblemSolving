public class MergeSort {
    public static void main(String[] args) {
        int arr[]={6,3,9,8,5,2};
        int start=0;
        int end=arr.length-1;
        mergeSort(arr, start, end);
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
    public static void mergeSort(int arr[] , int start , int end)
    {
    if(start>=end)
    {
        return;
    }
    int mid = start + (end-start)/2;
    mergeSort(arr, start, mid);
    mergeSort(arr, mid+1 , end);
    merge(arr, start, mid, end);
    }
    public static void merge(int arr[] , int start , int mid , int end)
    {
     int i = start;
     int j = mid+1;
     int k = 0;
     int temp[] = new int[end - start + 1];  // ✅ Correct size

     while(i<= mid && j<=end)
     {
        if(arr[i]<arr[j])
        {temp[k]=arr[i];
        k++;
        i++;
        }
        else{
            temp[k]=arr[j];
            j++;
            k++;
        }
     }
     while(i<=mid)
     {
        temp[k]=arr[i];
        k++;
        i++;
     }
     while(j<=end)
     {
        temp[k]=arr[j];
            j++;
            k++;
     }
     for(k=0,i=start;k<temp.length;k++,i++)
     {
        arr[i]=temp[k];
     }
    }
}
