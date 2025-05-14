public class insertion {
    public static void main(String[] args) {
        int arr[]={5,6,7,8,9,1,2,3,4};
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            int prev=i-1;
            int curr=arr[i];
            while(prev>=0 && arr[prev]>curr)
            {
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
