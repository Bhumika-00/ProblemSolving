public class subarraya {
    public static void main(String[] args) {
        int arr[]={2, 3, -8, 7, -1, 2, 3};
        int csum=0;
        int maxsum=Integer.MIN_VALUE;
        int i;
        for( i=0;i<arr.length;i++)
        {
              csum=csum+arr[i];
              if(csum<0)
              {
                csum=0;
              }
              maxsum = Math.max(csum,maxsum);
        }
        System.out.println(maxsum);
    }
}
