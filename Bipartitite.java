import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartitite {
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

    public static boolean Isbipartitite(ArrayList<Edge> graph[]) {
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }
        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q1.add(i);
                col[i] = 0;
                while (!q1.isEmpty()) {
                    int curr = q1.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j); // ✅ Correct index

                        if (col[e.destination] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.destination] = nextCol;
                            q1.add(e.destination);
                        } else if (col[curr] == col[e.destination]) {
                            return false;
                        }

                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.destination);
        }
       System.out.println(Isbipartitite(graph));
    }
}
