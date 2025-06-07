import java.util.Arrays;
import java.util.Comparator;

public class Greedy3 {
    public static void main(String[] args) {
        int price[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        double knap[][] = new double[price.length][4];

        for (int i = 0; i < price.length; i++) {
            knap[i][0] = i;
            knap[i][1] = price[i];
            knap[i][2] = weight[i];
            knap[i][3] = (double) price[i] / weight[i];  // Important: cast to double
        }

        int capacity = 50;
        double amt = 0;

        Arrays.sort(knap, Comparator.comparingDouble(row -> row[3])); // Fixed

        for (int i = price.length - 1; i >= 0; i--) {
            if (capacity >= (int) knap[i][2]) {
                amt += knap[i][1];
                capacity -= (int) knap[i][2];
            } else {
                amt += knap[i][3] * capacity;
                break;
            }
        }

        System.out.println(amt);  // Expected output: 240.0
    }
}
