import java.util.PriorityQueue;

public class SlidingWindow {

    // Make Pair static and implement Comparable
    static class Pair implements Comparable<Pair> {
        int max;
        int idx;

        Pair(int max, int idx) {
            this.max = max;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            return p2.max - this.max; // Max-Heap: higher max comes first
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = new int[arr.length - k + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }
        res[0] = pq.peek().max;

        for (int i = k; i < arr.length; i++) {
            while (!pq.isEmpty() && pq.peek().idx <= (i - k)) {
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            res[i - k + 1] = pq.peek().max;
        }

        for (int num : res) {
            System.out.println(num);
        }
    }
}
