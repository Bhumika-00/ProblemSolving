public class twodarray {
    public static void main(String[] args) {
        int arr[][]={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int key =6;
        int i=0,j=arr.length-1;
        while(i<arr.length && j>=0)
        {
            if(arr[i][j]==key)
            {
                System.out.println("Found"+i+" "+j);
                return;
            }
            else if(arr[i][j]>key)
           {
            j--;
           }
           else{
            i++;
           }
        }
    }
}
