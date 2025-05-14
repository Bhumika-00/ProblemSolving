public class kadanealgo {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 10 };
        int maxsum = Integer.MIN_VALUE;
        int csum = 0;
        for(int i=0;i<arr.length;i++)
        {
           csum+=arr[i];
           if(csum<0)
           {
            csum=0;
           }
           maxsum=Math.max(maxsum,csum);
        }
        System.out.println(maxsum);

    }
}
