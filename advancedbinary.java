public class advancedbinary {
    public static void main(String[] args) {
        int arr[]={4,5,6,7,8,9,1,2,3};
        int lb=0,mid;
        int target=7;
        int ub=arr.length-1;
        while(lb<=ub)
        {
        mid=ub+lb/2;
        if(arr[mid]==target)
        {
            System.out.println("Found " + mid);
            return ;
        }
       else if(arr[mid]>arr[lb])
        {
            if(arr[lb]<=target && target<arr[mid])
            {
                ub--;
            }
            else
            {
                lb++;
            }
        }
        else
        {
           if(arr[mid]<target && target<arr[ub])
           {
            lb++;
           }
           else
           {
            ub--;
           }
        }
        }
    }
}
