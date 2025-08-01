import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Travel {
    public static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static class Info {
        int v;
        int cost;
        int stops;

        Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static void cheapestFlight(int n, int flights[][], int src, int dest, int k, ArrayList<Edge> graph[]) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = (i == src) ? 0 : Integer.MAX_VALUE;
        }

        Queue<Info> q1 = new LinkedList<>();
        q1.add(new Info(src, 0, 0));

        while (!q1.isEmpty()) {
            Info curr = q1.remove();

            if (curr.stops > k) {
                continue;
            }

            // FIX: Use curr.v, not src
            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int w = e.weight;

                if (dist[u] != Integer.MAX_VALUE && curr.cost + w < dist[v]) {
                    dist[v] = curr.cost + w;
                    q1.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        if (dist[dest] == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(dist[dest]);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = {
            { 0, 1, 100 },
            { 1, 2, 100 },
            { 2, 0, 100 },
            { 1, 3, 600 },
            { 2, 3, 200 }
        };
        int src = 0;
        int dest = 3;
        int k = 1;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // FIX: Use u and v instead of re-declaring src and dest
        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int weight = flights[i][2];

            Edge e = new Edge(u, v, weight);
            graph[u].add(e);
        }

        cheapestFlight(n, flights, src, dest, k, graph);
    }
}
