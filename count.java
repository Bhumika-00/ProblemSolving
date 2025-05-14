public class count {
    public static void main(String[] args) {
        int arr[]={5,6,7,8,9,1,2,3,4};
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        int count[]=new int[max+1];
        for(int i=0;i<n;i++)
        {
            count[arr[i]]++;
        }
        int j=0;
        for(int i=0;i<count.length;i++)
        {
            while (count[i]>0)
            {
                arr[j]=i;
                j++;
                count[i]--;
                
            }
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
