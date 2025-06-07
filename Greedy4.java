import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy4 {
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 4};

        int activities[][] = new int[start.length][3];

        for (int i = 0; i < activities.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingInt(o -> o[2]));

        ArrayList<Integer> act = new ArrayList<>();
        int count = 1;
        int lastEndTime = activities[0][2];
        act.add(activities[0][0]);

        for (int i = 1; i < activities.length; i++) {
            if (activities[i][1] >= lastEndTime) {
                act.add(activities[i][0]); // Fixed line
                count++;
                lastEndTime = activities[i][2];
            }
        }

        System.out.println("Activities selected (indices): " + act);
        System.out.println("Maximum activities: " + count);
    }
}
