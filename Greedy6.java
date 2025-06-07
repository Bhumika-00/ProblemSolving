import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy6 {
    public static void main(String[] args) {
        int start[]={5,39,5,27,50};
        int end[]={24,60,28,40,90};
        int count=0;
        int pairs[][]=new int[start.length][3];
        for(int i=0;i<end.length;i++)
        {
            pairs[i][0]=i;
            pairs[i][1]=start[i];
            pairs[i][2]=end[i];
        }
        Arrays.sort(pairs,Comparator.comparingDouble(o->o[2]));
        ArrayList<Integer> list = new ArrayList<>();
        count++;
        list.add(pairs[0][0]);

        int ending = pairs[0][2];
        for(int i=1;i<end.length;i++)
        {
         if(pairs[i][1]>=ending)
         {
            count++;
            list.add(pairs[i][0]);

            ending=pairs[i][2];
         }
        }
        System.out.println(count);
        System.out.println(list);
    }
}
