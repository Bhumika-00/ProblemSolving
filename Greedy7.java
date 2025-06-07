import java.util.Arrays;
import java.util.Collections;

public class Greedy7 {
    public static void main(String[] args) {
        Integer coins[]={12,5,10,20,50,100,200,500,2000};
        int amt=590;
        int ct=0;
        Arrays.sort(coins,Collections.reverseOrder());
        for(int i=0;i<coins.length;i++)
        {
            if(amt>=coins[i])
            {
                while(amt>=coins[i])
                {
                    ct++;
                    amt=amt-coins[i];
                    
                }
            }
        }
        System.out.println(ct);
    }
}
