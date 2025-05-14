public class subarray {
    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8, 10};
        int maxsum = Integer.MIN_VALUE;
        
       
        for ( int i = 0; i < arr.length; i++) {
            int start = i;
        
            for (int j = i; j < arr.length; j++) {
                int end = j + 1;
                int csum = 0;
                for (int k = start; k < end; k++) {
                    csum += arr[k];
                   
                }
                if (maxsum < csum) {
                    maxsum = csum;
                }
               
            }
           
        }
        
        System.out.println("Maximum Subarray Sum: " + maxsum);
    }
}

