import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
public class MajorityElement {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // Add elements to the list
        int[] arr = {1, 2};
        for (int num : arr) {
            list.add(num);
        }

        HashMap<Integer, Integer> hmp = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
             if(hmp.containsKey(list.get(i)))
            {
                hmp.put(list.get(i), hmp.get(list.get(i))+1);
            }
            else{
                hmp.put(list.get(i), 1);
            }
           
        }
        Set<Integer> s1 = hmp.keySet();
        for(Integer freq:s1)
        {
            if(hmp.get(freq)>list.size()/3)
            {
                System.out.println(freq);
            }
        }

        

        
    }
}
