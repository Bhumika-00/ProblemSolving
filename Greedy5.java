import java.util.Arrays;
import java.util.Comparator;

public class Greedy5 {
    public static void main(String[] args) {
        int value[]={60,100,120};
        int weight[]={10,20,30};
        float price=0;
        float wt=50;
        float knapscak[][]=new float[value.length][4];
        for(int i=0;i<value.length;i++)
        {
            knapscak[i][0]=i;
            knapscak[i][1]=value[i];
            knapscak[i][2]=weight[i];
            knapscak[i][3]=(value[i]/weight[i]);
        }
      Arrays.sort(knapscak , Comparator.comparingDouble(o -> o[3]));


        for(int i=value.length-1;i>=0;i--)
        {
         if(wt>=knapscak[i][2])
         {
            price=price+knapscak[i][1];
            wt=wt-knapscak[i][2];

         }
         else{
            price=price+knapscak[i][3]*wt;
            break;
         }
        }
        System.out.println(price);
    }
}
