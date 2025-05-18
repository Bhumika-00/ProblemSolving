import java.util.ArrayList;

public class TwoD {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        list.add(arr);
        System.out.println(list);
        System.out.println(arr);
          
    }
}
