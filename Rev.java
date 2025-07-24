import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Rev {
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
        boolean isValidBFS[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isValidBFS[i]) {
                utilBFS(graph, isValidBFS, i);
            }
        }
    }

    public static void utilBFS(ArrayList<Edge> graph[], boolean isValidBFS[], int num) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(num);
        while (!q1.isEmpty()) {
            int curr = q1.remove();
            if (!isValidBFS[curr]) {
                isValidBFS[curr] = true;
                System.out.print(curr + " ");
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q1.add(e.destination);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge> graph[]) {
        boolean isValidDFS[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isValidDFS[i]) {
                utilDFS(graph, isValidDFS, i);
            }
        }
    }

    public static void utilDFS(ArrayList<Edge> graph[], boolean isValidDFS[], int num) {
        isValidDFS[num] = true;
        System.out.print(num + " ");
        for (int i = 0; i < graph[num].size(); i++) {
            Edge e = graph[num].get(i);
            if (!isValidDFS[e.destination]) {
                utilDFS(graph, isValidDFS, e.destination);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[], boolean isValidhasPath[], int src, int dest) {
        if (src == dest) {
            return true;
        }
        isValidhasPath[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!isValidhasPath[e.destination]) {
                if (hasPath(graph, isValidhasPath, e.destination, dest)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycleDetection(ArrayList<Edge> graph[]) {
        boolean isValidCycle[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isValidCycle[i]) {
                if (utilCycleDetection(graph, isValidCycle, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean utilCycleDetection(ArrayList<Edge> graph[], boolean isValidCycle[], int curr, int par) {
        isValidCycle[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isValidCycle[e.destination]) {
                if (utilCycleDetection(graph, isValidCycle, e.destination, curr)) {
                    return true;
                }
            } else if (e.destination != par) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean isVistedCycle[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVistedCycle[i]) {
                if (utilCycleDetection(graph, isVistedCycle, stack, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean utilCycleDetection(ArrayList<Edge> graph[], boolean isVistedCycle[], boolean stack[],
            int num) {
        isVistedCycle[num] = true;
        stack[num] = true;
        for (int i = 0; i < graph[num].size(); i++) {
            Edge e = graph[num].get(i);
            if (!isVistedCycle[e.destination]) {
                if (utilCycleDetection(graph, isVistedCycle, stack, e.destination)) {
                    return true;
                }
            }
        }
        stack[num] = false;
        return false;
    }

    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];
        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < color.length; i++) {
            if (color[i] == -1) {
                q1.add(i);
                color[i] = 0;
                while (!q1.isEmpty()) {
                    int curr = q1.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (color[e.destination] == -1) {
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.destination] = nextColor;
                            q1.add(e.destination);
                        } else if (color[e.destination] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void topologicalSort(ArrayList<Edge> graph[]) {
        boolean isValidSort[] = new boolean[graph.length];
        Stack<Integer> s1 = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!isValidSort[i]) {
                utilTopologicalSort(graph, isValidSort, s1, i);
            }
        }

        while (!s1.isEmpty()) {
            System.out.print(s1.pop()+" ");
        }
    }

    public static void utilTopologicalSort(ArrayList<Edge> graph[], boolean isValidSort[], Stack<Integer> s1, int num) {
        isValidSort[num] = true;

        for (int i = 0; i < graph[num].size(); i++) {
            Edge e = graph[num].get(i);
            if (!isValidSort[e.destination]) {
                utilTopologicalSort(graph, isValidSort, s1, e.destination);
            }
        }
        s1.push(num);
    }

    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph2[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            graph2[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[1].add(new Edge(1, 0, 2));

        graph[0].add(new Edge(0, 2, 4));
        graph[2].add(new Edge(2, 0, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[3].add(new Edge(3, 1, 7));

        graph[2].add(new Edge(2, 4, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph2[0].add(new Edge(0, 1, 1));
        graph2[0].add(new Edge(0, 2, 1));

        graph2[1].add(new Edge(1, 3, 1));

        graph2[2].add(new Edge(2, 3, 1));
        graph2[2].add(new Edge(2, 4, 1));

        graph2[3].add(new Edge(3, 5, 1));

        graph2[4].add(new Edge(4, 5, 1));
        BFS(graph);
        System.out.println();
        System.out.println("-------------------------------------");
        DFS(graph);
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println(hasPath(graph, new boolean[graph.length], 0, 1));
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println(cycleDetection(graph));
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println(isBipartite(graph));
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println(cycleDetection(graph));
        System.out.println();
        System.out.println("-------------------------------------");
        topologicalSort(graph2);

    }
}
