import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphPractise {
    public static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void BFS(ArrayList<Edge> graph[]) {
        boolean isVisitedBFS[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVisitedBFS[i]) {
                utilBFS(graph, isVisitedBFS, i);
            }
        }
    }

    public static void utilBFS(ArrayList<Edge> graph[], boolean isVisitedBFS[], int num) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(num);

        while (!q1.isEmpty()) {
            int curr = q1.remove();
            System.out.print(curr + " ");
            isVisitedBFS[curr] = true;
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (!isVisitedBFS[curr]) {
                    q1.add(e.destination);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge> graph[]) {
        boolean isVisitedDFS[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVisitedDFS[i]) {
                utilDFS(graph, isVisitedDFS, i);
            }

        }
    }

    public static void utilDFS(ArrayList<Edge> graph[], boolean isVisitedDFS[], int curr) {

        isVisitedDFS[curr] = true;
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isVisitedDFS[e.destination]) {
                utilDFS(graph, isVisitedDFS, e.destination);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[], boolean[] isVisitedPath, int src, int dest) {
        if (src == dest) {
            return true;
        }

        isVisitedPath[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!isVisitedPath[e.destination]) {
                if (hasPath(graph, isVisitedPath, e.destination, dest)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean cycleDetection(ArrayList<Edge> graph[]) {
        boolean isVisitedCycle[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVisitedCycle[i]) {
                if (utilCycleDetection(graph, isVisitedCycle, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean utilCycleDetection(ArrayList<Edge> graph[], boolean isVisitedCycle[], int curr, int par) {
        isVisitedCycle[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isVisitedCycle[e.destination]) {
                if (utilCycleDetection(graph, isVisitedCycle, e.destination, curr)) {
                    return true;
                }
            } else if (e.destination != par) {
                return true;
            }
        }
        return false;
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
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 0, 1));

        graph[0].add(new Edge(0, 2, 1));
        graph[2].add(new Edge(2, 0, 1));

        graph[1].add(new Edge(1, 3, 1));
        graph[3].add(new Edge(3, 1, 1));

        graph[2].add(new Edge(2, 4, 1));
        graph[4].add(new Edge(4, 2, 1));

        graph[3].add(new Edge(3, 5, 1));
        graph[5].add(new Edge(5, 3, 1));

        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 4, 1));

        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));

        BFS(graph);
        System.out.println();
        System.out.println("----------------------------------------");
        DFS(graph);
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println(hasPath(graph, new boolean[graph.length], 0, 3));
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println(cycleDetection(graph));
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println(Isbipartitite(graph));
    }
}
