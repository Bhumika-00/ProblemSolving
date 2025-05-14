import java.util.ArrayList;

public class FindOut {
    public static void main(String[] args) {
        int arr[]={3,2,4,5,6,2,7,2,2};
        int key=2;
        int i=0;
        ArrayList<Integer> ne = new ArrayList<>();
        System.out.println(position(arr, key, i, ne));
    }
    public static ArrayList position(int arr[],int key,int i,ArrayList<Integer> ne)
    {
     if(i==arr.length)
     {
      return ne;
     }
     if(arr[i]==key)
     {
        ne.add(i);
       return position(arr, key, i+1, ne);
     }
     return position(arr, key, i+1, ne);
    }
}
