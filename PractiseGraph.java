import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PractiseGraph {
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

    public static void BFS(ArrayList<Edge>[] graph) {
        boolean isVistedBFS[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVistedBFS[i]) {
                utilBFS(graph, isVistedBFS, i);
            }
        }
    }

    public static void utilBFS(ArrayList<Edge>[] graph, boolean isVistedBFS[], int num) {

        Queue<Integer> q1 = new LinkedList<>();
        q1.add(num);

        if (!isVistedBFS[num]) {
            isVistedBFS[num] = true;
            System.out.print(num + " ");
            for (int i = 0; i < graph[num].size(); i++) {
                Edge e = graph[num].get(i);
                q1.add(e.dest);
            }
        }

    }

    public static void DFS(ArrayList<Edge>[] graph) {
        boolean isVistedDFS[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVistedDFS[i]) {
                utilDFS(graph, isVistedDFS, i);
            }
        }
    }

    public static void utilDFS(ArrayList<Edge>[] graph, boolean isVistedDFS[], int num) {
        isVistedDFS[num] = true;
        System.out.print(num + " ");

        for (int i = 0; i < graph[num].size(); i++) {

            Edge e = graph[num].get(i);
            if (!isVistedDFS[e.dest]) {
                utilDFS(graph, isVistedDFS, e.dest);
            }

        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, boolean isVistedPath[], int src, int dest) {
        if (src == dest) {
            return true;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!isVistedPath[e.dest]) {

                if (hasPath(graph, isVistedPath, e.dest, dest)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean hasCycleDetection()
    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        // Initialize each ArrayList
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges
        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 3));
        graph[1].add(new Edge(1, 3, 6));
        graph[2].add(new Edge(2, 4, 4));
        graph[3].add(new Edge(3, 5, 2));
        graph[4].add(new Edge(4, 5, 7));

        BFS(graph);
        System.out.println();
        System.out.println("---------------------------------");
        DFS(graph);
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println(hasPath(graph, new boolean[graph.length], 0, 5));
        ;

    }
}
