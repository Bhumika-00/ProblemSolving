import java.util.Arrays;
import java.util.Collections;

public class Greedy8 {
    public static void main(String[] args) {
        int n = 4;
        int m = 6;
        Integer horizontalCost[] = {4, 2, 1};
        Integer verticalCost[] = {4, 3, 2, 1, 1};
        Arrays.sort(verticalCost, Collections.reverseOrder());
        Arrays.sort(horizontalCost, Collections.reverseOrder());
        int v = 0, h = 0;
        int vp = 1, hp = 1;
        int cost = 0;

        while (v < verticalCost.length && h < horizontalCost.length) {
            if (horizontalCost[h] < verticalCost[v]) {
                cost += verticalCost[v] * hp;
                v++;
                vp++;
            } else {
                cost += horizontalCost[h] * vp;
                h++;
                hp++;
            }
        }

        while (v < verticalCost.length) {
            cost += verticalCost[v] * hp;
            v++;
        }

        while (h < horizontalCost.length) {
            cost += horizontalCost[h] * vp;
            h++;
        }

        System.out.println(cost);
    }
}
