import java.util.ArrayList;

public class ReverseOfArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        reverse(list);
    }
    public static void reverse(ArrayList<Integer>list)
    {
        int end = list.size()-1;
        int start = 0;
        int temp;
        while(start<end)
        {
        temp = list.get(start);
        list.set(start , list.get(end));
        list.set(end,temp);
        start++;
        end--;
        }
        System.out.println(list);
    }
}
