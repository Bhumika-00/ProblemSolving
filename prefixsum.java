public class prefixsum {
   
        public static void main(String[] args) {
            int arr[] = {2, 4, 6, 8, 10};
            int maxsum = Integer.MIN_VALUE;
            int prefixsum[] = new int[arr.length];
            
            // Compute prefix sums
            prefixsum[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                prefixsum[i] = prefixsum[i - 1] + arr[i];
            }
            
            int i = 0;
            for (; i < arr.length; i++) {
                int start = i;
                int j = i;
                for (; j < arr.length; j++) {
                    int end = j;
                    int csum = (start == 0) ? prefixsum[end] : prefixsum[end] - prefixsum[start - 1];
                    
                    if (maxsum < csum) {
                        maxsum = csum;
                    }
                }
            }
            
            System.out.println("Maximum Subarray Sum: " + maxsum);
        }
    }
    

