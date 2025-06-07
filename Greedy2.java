import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy2 {
    public static void main(String[] args) {
        int start[]={10,20,12};
        int end[]={20,30,25};
        int act[][]=new int[start.length][3];
        for(int i=0;i<start.length;i++)
        {
            act[i][0]=i;
            act[i][1]=start[i];
            act[i][2]=end[i];
        }
        Arrays.sort(act,Comparator.comparingDouble(o->o[2]));
        for(int i=0;i<start.length;i++)
        {
            System.out.println(act[i][2]);
        }
      
    }
}
