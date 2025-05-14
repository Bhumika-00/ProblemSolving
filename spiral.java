public class spiral{
    public static void main(String[] args) {
        int arr[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}; 
        int start_r=0;
        int start_col=0;
        int last_r=arr.length-1;
        int last_col=arr[0].length-1;
        while(last_col>=start_col && last_r>=start_r){
            for(int i=start_col;i<=last_col;i++){
                System.out.print(arr[start_r][i]+" ");
            }
            for(int i=start_r+1;i<=last_r;i++)
            {
                System.out.print(arr[i][last_col]+" ");
            }
            for(int i=last_col-1;i>=start_col;i--){
                System.out.print(arr[last_r][i]+" ");
            }
            for(int i=last_r-1;i>start_r;i--){
                System.out.print(arr[i][start_col]+" ");
            }
            start_r++;
            start_col++;
            last_r--;
            last_col--;
        }
    }
}