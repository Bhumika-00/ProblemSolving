import java.util.ArrayList;
import java.util.Collections;

public class MaximumEle {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        max(list);
        Collections.sort(list , Collections.reverseOrder());
        System.out.println(list);
    }
    public static void max(ArrayList<Integer>list)
    {
        int max_num = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i)>max_num)
            {
                max_num = list.get(i);
            }
        }
        System.out.println(max_num);
    }
}
