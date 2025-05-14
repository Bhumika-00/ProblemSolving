public class bubble {
    public static void main(String[] args) {
        int arr[]={5,6,7,8,9,1,2,3,4};
        int n=arr.length;
        for(int i=0;i<=n-2;i++)
        {
            for(int j=0;j<=n-i-2;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
