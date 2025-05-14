public class reverse{
    public static void main(String args[])
    {
        int arr[]={2,4,6,8,10} ;
        int start=0;
        int end =arr.length-1;
        int temp;
        while(start<=end)
           { temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
           }
        
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
            
        }
    }
}