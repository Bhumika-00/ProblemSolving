public class selection {
    public static void main(String[] args) {
        int arr[] = {5,6,7,8,9,1,2,3,4};
        int n = arr.length;
        for(int i=0;i<=n-2;i++)
        {
            int minpos=i;
            for(int j=i+1;j<=n-1;j++)
            {
                if(arr[minpos]>arr[j])
                {
                    minpos=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minpos];
            arr[minpos]=temp;
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
