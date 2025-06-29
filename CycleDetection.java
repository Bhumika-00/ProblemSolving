import java.util.ArrayList;

public class CycleDetection {
    public static class Edge {
        int src;
        int destination;
        int weight;

        Edge(int src, int destination, int weight) {
            this.src = src;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Main method to check for a cycle in the graph
    public static boolean cycleDetection(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (utilcycleDetection(graph, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    // DFS helper for cycle detection
    public static boolean utilcycleDetection(ArrayList<Edge>[] graph, boolean visited[], int curr, int parent) {
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!visited[e.destination]) {
                if (utilcycleDetection(graph, visited, e.destination, curr)) {
                    return true;
                }
            } else if (e.destination != parent) {
                // If visited and not parent → back edge → cycle
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Undirected edges (add both directions)
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 0, 5));

        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[1].add(new Edge(1, 3, 3));
        graph[3].add(new Edge(3, 1, 3));

        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 2, 1));

        graph[2].add(new Edge(2, 4, 2));
        graph[4].add(new Edge(4, 2, 2));

        System.out.println("Cycle Present? " + cycleDetection(graph));
    }
}
