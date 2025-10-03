import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Prac {
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
        boolean isVisitedBFS[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVisitedBFS[i]) {
                utilBFS(graph, isVisitedBFS, i);
            }
        }
    }

    public static void utilBFS(ArrayList<Edge>[] graph, boolean isVisitedBFS[], int num) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(num);
        while (!q1.isEmpty()) {
            int curr = q1.remove();
            if (!isVisitedBFS[curr]) {
                isVisitedBFS[curr] = true;
                System.out.println(curr);
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q1.add(e.dest);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge>[] graph) {
        boolean isVisitedDFS[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVisitedDFS[i]) {
                utilDFS(graph, isVisitedDFS, i);
            }
        }
    }

    public static void utilDFS(ArrayList<Edge>[] graph, boolean isVisitedDFS[], int num) {
        isVisitedDFS[num] = true;
        System.out.println(num);

        for (int i = 0; i < graph[num].size(); i++) {
            Edge e = graph[num].get(i);
            if (!isVisitedDFS[e.dest]) {
                utilDFS(graph, isVisitedDFS, e.dest);
            }

        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, boolean isVisitedPath[], int src, int dest) {
        if (src == dest) {
            return true;
        }
        isVisitedPath[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!isVisitedPath[e.dest]) {
                if (hasPath(graph, isVisitedPath, e.dest, dest)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasCycleDetection(ArrayList<Edge>[] graph) {
        boolean isVisitedCycle[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVisitedCycle[i]) {
                if (utilhasCycleDetection(graph, isVisitedCycle, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean utilhasCycleDetection(ArrayList<Edge>[] graph, boolean isVisitedCycle[], int curr, int par) {
        isVisitedCycle[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isVisitedCycle[e.dest]) {
                if (utilhasCycleDetection(graph, isVisitedCycle, e.dest, curr)) {
                    return true;
                }
            } else if (e.dest != par) {
                return true;
            }
        }
        return false;
    }

    public static boolean bipartiteGraph(ArrayList<Edge>[] graph) {
        int color[] = new int[graph.length];
        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < color.length; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                q1.add(i);
            }
            while (!q1.isEmpty()) {
                int curr = q1.remove();
                for (int j = 0; j < graph[curr].size(); j++) {
                    Edge e = graph[curr].get(j);
                    if (color[e.dest] == -1) {
                        int nextCol = color[curr] == 0 ? 1 : 0;
                        color[e.dest] = nextCol;
                        q1.add(e.dest);
                    } else if (color[curr] == color[e.dest]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean cycle(ArrayList<Edge>[] graph) {
        boolean[] isVisited = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!isVisited[i]) {
                if (utilcycle(graph, isVisited, stack, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean utilcycle(ArrayList<Edge>[] graph, boolean[] isVisited, boolean[] stack, int curr) {
        isVisited[curr] = true;
        stack[curr] = true;

        for (Edge e : graph[curr]) {
            if (!isVisited[e.dest]) {
                if (utilcycle(graph, isVisited, stack, e.dest)) {
                    return true;
                }
            } else if (stack[e.dest]) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }

    public static void toplogicalSort(ArrayList<Edge>[] graph) {
        boolean isVisitedSort[] = new boolean[graph.length];
        Stack<Integer> s1 = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!isVisitedSort[i]) {
                utilTopplogicalSort(graph, isVisitedSort, s1, i);
            }
        }
        while (!s1.isEmpty()) {
            System.out.println(s1.pop());
        }
    }

    public static void utilTopplogicalSort(ArrayList<Edge>[] graph, boolean isVisitedSort[], Stack<Integer> s1,
            int curr) {
        isVisitedSort[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isVisitedSort[e.dest]) {
                utilTopplogicalSort(graph, isVisitedSort, s1, e.dest);
            }
        }
        s1.push(curr);
    }

    public static void calIndeg(ArrayList<Edge>[] graph, int indeg[]) {
        for (int i = 0; i < indeg.length; i++) {
            int V = i;
            for (int j = 0; j < graph[V].size(); j++) {
                Edge e = graph[V].get(j);

                indeg[e.dest]++;
            }
        }
    }

    public static void khanAlgo(ArrayList<Edge>[] graph) {
        int indeg[] = new int[graph.length];
        calIndeg(graph, indeg);
        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q1.add(i);
            }
        }
        while (!q1.isEmpty()) {
            int curr = q1.remove();
            System.out.println(curr);
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q1.add(e.dest);
                }
            }

        }

    }

    public static void allPath(ArrayList<Edge> graph[], int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            allPath(graph, e.dest, dest, path + src);
        }
    }

    public static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void dijikstraAlgo()
    {
        
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

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 4, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 5, 5));
        BFS(graph);
        System.out.println("------------------------------------");
        DFS(graph);
        System.out.println("------------------------------------");
        System.out.println(hasPath(graph, new boolean[graph.length], 0, 5));
        System.out.println("------------------------------------");
        System.out.println(hasCycleDetection(graph));
        System.out.println("------------------------------------");
        System.out.println(bipartiteGraph(graph));
        System.out.println("------------------------------------");
        System.out.println(cycle(graph));
        System.out.println("------------------------------------");
        toplogicalSort(graph);
        System.out.println("------------------------------------");
        khanAlgo(graph);
        System.out.println("------------------------------------");
        allPath(graph, 0, 5, "");

    }
}
