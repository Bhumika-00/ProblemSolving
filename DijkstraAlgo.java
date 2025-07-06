import java.util.*;

public class DijkstraAlgo {
    
    public static class Edge {
        int src, destination, weight;
        Edge(int src, int destination, int weight) {
            this.src = src;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int node, dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair other) {
            return this.dist - other.dist;  // min-heap
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        boolean[] visited = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;

            if (visited[u]) continue;
            visited[u] = true;

            for (Edge e : graph[u]) {
                int v = e.destination;
                int wt = e.weight;

                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("To " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        int src = 0;
        dijkstra(graph, src);
    }
}
