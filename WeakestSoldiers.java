import java.util.PriorityQueue;

public class WeakestSoldiers {

    static class Soldiers implements Comparable<Soldiers> {
        int soldiers;
        int idx;

        Soldiers(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Soldiers s2) {
            if (this.soldiers == s2.soldiers) {
                return this.idx - s2.idx;
            } else {
                return this.soldiers - s2.soldiers;
            }
        }
    }

    public static void main(String[] args) {
        int[][] army = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        };
        int k = 2;
        PriorityQueue<Soldiers> pq = new PriorityQueue<>();
        
        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[0].length; j++) {
                if (army[i][j] == 1) {
                    count++;
                }
            }
            pq.add(new Soldiers(count, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println(pq.remove().idx);
        }
    }
}
