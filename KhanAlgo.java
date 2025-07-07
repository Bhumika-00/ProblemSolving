import java.util.*;

public class KhanAlgo {
    public static class Edge {
        int src;
        int destination;

        Edge(int src, int destination) {
            this.src = src;
            this.destination = destination;
        }
    }

    // Function to calculate indegrees
    public static void calindeg(ArrayList<Edge>[] graph, int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.destination]++;
            }
        }
    }

    public static void topologicalSort(ArrayList<Edge>[] graph) {
        int indeg[] = new int[graph.length];
        calindeg(graph, indeg);

        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q1.add(i);
            }
        }

        System.out.print("Topological Order: ");
        while (!q1.isEmpty()) {
            int curr = q1.remove();
            System.out.print(curr);
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.destination]--;
                if (indeg[e.destination] == 0) {
                    q1.add(e.destination);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        topologicalSort(graph);
    }
}
