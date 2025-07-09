import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Gractic {
    public static class Edge {
        int src;
        int destination;

        Edge(int src, int destination) {
            this.src = src;
            this.destination = destination;
        }
    }

    public static void BFS(ArrayList<Edge> graph[]) {
        boolean isvalid[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isvalid[i]) {
                utilBFS(graph, isvalid, i);
            }

        }
    }

    public static void utilBFS(ArrayList<Edge> graph[], boolean isvalid[], int num) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(num);
        while (!q1.isEmpty()) {
            int curr = q1.remove();

            if (!isvalid[curr]) {
                isvalid[curr] = true;
                System.out.print(curr + " ");
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q1.add(e.destination);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge> graph[]) {
        boolean isvalidDFS[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isvalidDFS[i]) {
                utilDFS(graph, isvalidDFS, i);
            }

        }
    }

    public static void utilDFS(ArrayList<Edge> graph[], boolean isvalidDFS[], int num) {
        System.out.print(num + " ");
        isvalidDFS[num] = true;
        for (int i = 0; i < graph[num].size(); i++) {
            Edge e = graph[num].get(i);
            if (!isvalidDFS[e.destination]) {
                utilDFS(graph, isvalidDFS, e.destination);
            }
        }

    }

    public static boolean hasPath(ArrayList<Edge> graph[], int start, int end) {
        boolean isvalidPath[] = new boolean[graph.length];
        return utilHasPath(graph, start, end, isvalidPath);
    }

    public static boolean utilHasPath(ArrayList<Edge> graph[], int curr, int end, boolean[] isvalidPath) {
        if (curr == end) {
            return true;
        }
        isvalidPath[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isvalidPath[e.destination]) {
                if (utilHasPath(graph, e.destination, end, isvalidPath)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasCycle(ArrayList<Edge> graph[]) {
        boolean validCycle[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!validCycle[i]) {
                if (utilHasCycle(graph, validCycle, i, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean utilHasCycle(ArrayList<Edge> graph[], boolean validCycle[], int curr, int parent) {
        validCycle[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!validCycle[e.destination]) {
                if (utilHasCycle(graph, validCycle, e.destination, curr)) {
                    return true;
                }
            }

            else if (e.destination != parent) {
                return true;
            }
        }
        return false;
    }

    public static boolean bipartite(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];
        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < color.length; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                q1.add(i);
                while (!q1.isEmpty()) {
                    int curr = q1.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (color[e.destination] == -1) {
                            int currcol = color[curr] == 0 ? 1 : 0;
                            color[e.destination] = currcol;
                            q1.add(e.destination);
                        }
                        if (color[curr] == color[e.destination]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void IndegreeCal(ArrayList<Edge> graph[], int inDegree[]) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                inDegree[e.destination]++;
            }

        }
    }

    public static void khanAlgo(ArrayList<Edge> graph[]) {
        int inDegree[] = new int[graph.length];
        IndegreeCal(graph, inDegree);    // 🔥 correct one for your use case

        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q1.add(i);
            }
        }

        while (!q1.isEmpty()) {
            int curr = q1.remove();
            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDegree[e.destination]--;

                if (inDegree[e.destination] == -1) {
                    q1.add(e.destination);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 6));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 4));
        graph[6].add(new Edge(6, 5));

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph2[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph2[i] = new ArrayList<>();
        }

        // Add edges to form a DAG
        graph2[0].add(new Edge(0, 1));
        graph2[0].add(new Edge(0, 2));

        graph2[1].add(new Edge(1, 3));

        graph2[2].add(new Edge(2, 4));

        graph2[3].add(new Edge(3, 5));

        graph2[4].add(new Edge(4, 6));
        BFS(graph);
        System.out.println();
        System.out.println("------------------------");
        DFS(graph);
        System.out.println();
        System.out.println("------------------------");
        System.out.println(hasPath(graph, 0, 3));
        System.out.println("------------------------");
        System.out.println(hasCycle(graph));
        System.out.println("------------------------");
        System.out.println(bipartite(graph));
        System.out.println();
        System.out.println("------------------------");
        khanAlgo(graph2);
    }
}
