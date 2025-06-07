import java.util.ArrayList;

public class Greedy1 {
    public static void main(String[] args) {
        int start[]={1,3,0,4,8,5};
        int end[]={2,4,6,7,9,9};
        int count=1;
        ArrayList<Integer> list = new ArrayList<>();
        int ending=end[0];
        list.add(0);
        for(int i=1;i<start.length;i++)
        {
            if(start[i]>=ending)
            {
            list.add(i);
            count++;
            ending=end[i];
            }
        }
        System.out.println(count);
        System.out.println(list);
    }
}
