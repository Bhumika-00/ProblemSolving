import java.util.*;

public class CheapestPathForFlights {
    static class Edge {
        int src, dest, wt;
        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int n, cost;
        Pair(int n, int c) {
            this.n = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph, int[][] flights) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            int src = flight[0];
            int dest = flight[1];
            int wt = flight[2];
            graph[src].add(new Edge(src, dest, wt));
        }
    }

    static void pathCheap(int V, int[][] flights, int src, int dest, int k) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, flights);

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        int stops = 0;

        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            int[] temp = Arrays.copyOf(dist, V);

            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();

                for (Edge e : graph[curr.n]) {
                    int u = e.src;
                    int v = e.dest;
                    int w = e.wt;

                    if (curr.cost + w < temp[v]) {
                        temp[v] = curr.cost + w;
                        q.add(new Pair(v, temp[v]));
                    }
                }
            }

            dist = temp;
            stops++;
        }

        if (dist[dest] == Integer.MAX_VALUE) {
            System.out.println("No path within " + k + " stops.");
        } else {
            System.out.println("Cheapest price from " + src + " to " + dest + " with max " + k + " stops is: " + dist[dest]);
        }
    }

    public static void main(String[] args) {
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {0, 2, 500},
            {2, 3, 100},
            {1, 3, 200}
        };

        int V = 4;
        int src = 0, dest = 3, k = 1;

        pathCheap(V, flights, src, dest, k);
    }
}
