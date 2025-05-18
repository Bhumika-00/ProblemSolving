import java.util.ArrayList;

public class ConatinerWithMostWater {
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        bruteforce(height);
        twopointer(height);
    }

    public static void bruteforce(ArrayList<Integer> height) {
        int width;
        int h;
        int area;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                h = Math.min(height.get(i), height.get(j));
                width = j - i;
                area = h * width;
                maxArea = Math.max(maxArea, area);
            }
        }
        System.out.println(maxArea);
    }

public static void twopointer(ArrayList<Integer> height)
{
    int lp=0;
    int rp=height.size()-1;
     int width;
    int h;
    int area;
    int maxArea = Integer.MIN_VALUE;
    while(lp<rp)
    {
       h = Math.min(height.get(lp), height.get(rp));
            width = rp - lp;
            area = h * width;
            maxArea = Math.max(maxArea, area);
            if(height.get(lp)<height.get(rp))
            {
                lp++;
            }
            else{
                rp--;
            }
    }
    System.out.println(maxArea);

}

}
