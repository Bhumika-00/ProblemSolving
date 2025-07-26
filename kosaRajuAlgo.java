import java.util.ArrayList;
import java.util.Stack;

public class kosaRajuAlgo {
    public static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void kosaraju(ArrayList<Edge> graph[], int V) {
        boolean isVisited[] = new boolean[graph.length];
        Stack<Integer> s1 = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!isVisited[i]) {
                topologicalSort(graph, isVisited, s1, i);
            }
        }
        @SuppressWarnings("unchecked")
        ArrayList<Edge> transpose[] = new ArrayList[graph.length];

        for (int i = 0; i < transpose.length; i++) {
            isVisited[i] = false;
            transpose[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }
        while (!s1.isEmpty()) {
            int curr = s1.pop();
            if (!isVisited[curr]) {
                System.err.print("SCC ->");
                dfs(transpose, isVisited, curr);
                System.out.println();
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], boolean isVisited[], int num) {
        isVisited[num] = true;
        System.out.print(num + " ");
        for (int i = 0; i < graph[num].size(); i++) {
            Edge e = graph[num].get(i);
            if (!isVisited[e.dest]) {
                dfs(graph, isVisited, e.dest); // fixed
            }
        }
    }

    public static void topologicalSort(ArrayList<Edge> graph[], boolean isVisited[], Stack<Integer> s1, int num) {
        isVisited[num] = true;
        for (int i = 0; i < graph[num].size(); i++) {
            Edge e = graph[num].get(i);
            if (!isVisited[e.dest]) {
                topologicalSort(graph, isVisited, s1, e.dest);
            }

        }
        s1.push(num);

    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
        kosaraju(graph, V);
    }
}
