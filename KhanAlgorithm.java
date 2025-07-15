import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KhanAlgorithm {
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

    public static void calculateInDegree(ArrayList<Edge>[] graph, int[] inDegree) {
        for (int i = 0; i < graph.length; i++) {
            for (Edge e : graph[i]) {
                inDegree[e.destination]++;
            }
        }
    }

    public static void khan(ArrayList<Edge>[] graph) {
        int[] inDegree = new int[graph.length];
        calculateInDegree(graph, inDegree);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        ArrayList<Integer> topoOrder = new ArrayList<>();

        while (!q.isEmpty()) {
            int curr = q.remove();
            topoOrder.add(curr);
            count++;

            for (Edge e : graph[curr]) {
                inDegree[e.destination]--;
                if (inDegree[e.destination] == 0) {
                    q.add(e.destination);
                }
            }
        }

        if (count != graph.length) {
            System.out.println("Cycle detected: Topological sort not possible.");
        } else {
            System.out.print("Topological Order: ");
            for (int node : topoOrder) {
                System.out.print(node + " ");
            }
            System.out.println("\ncycle completed.");
        }
    }

    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Graph with a cycle: 1 → 2 → 3 → 4 → 1
        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[4].add(new Edge(4, 5, 1)); // cycle
        graph[5].add(new Edge(5, 6, 1));

        khan(graph);
    }}