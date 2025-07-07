import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Practise {
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
        boolean[] isVisited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVisited[i]) {
                utilBFS(graph, isVisited, i);
            }
        }

    }

    public static void utilBFS(ArrayList<Edge>[] graph, boolean[] isVisited, int num) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(num);
        while (!q1.isEmpty()) {
            int curr = q1.remove();
            if (!isVisited[curr]) {
                System.out.println(curr);
                isVisited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q1.add(e.dest);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge>[] graph) {
        boolean isVisited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            utilBFS(graph, isVisited, i);
        }
    }

    public static void utilDFS(ArrayList<Edge>[] graph, boolean isVisited[], int num) {
        System.out.println(num);
        isVisited[num] = true;
        for (int i = 0; i < graph[num].size(); i++) {
            Edge e = graph[num].get(i);
            if (!isVisited[e.dest]) {
                utilBFS(graph, isVisited, e.dest);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int source, int destination, boolean isVisited[]) {
        if (source == destination) {
            return true;
        }
        isVisited[source] = true;
        for (int i = 0; i < graph[source].size(); i++) {
            Edge e = graph[source].get(i);
            if (!isVisited[e.dest] && hasPath(graph, e.dest, destination, isVisited)) {
                return true;
            }
        }
        return false;
    }
    public static boolean cycleDetection(ArrayList<Edge>[] graph)
    {
        boolean isVistedCycle[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(!isVistedCycle[i])
            {
                if(utilCycleDetection(graph, isVistedCycle, i, 0))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean utilCycleDetection(ArrayList<Edge>[] graph , boolean isVistedCycle[] , int num , int par)
    {
    isVistedCycle[num]=true;
    for(int i=0;i<graph[num].size();i++)
    {
        Edge e = graph[num].get(i);
        if(isVistedCycle[e.dest])
        {
            if(utilCycleDetection(graph, isVistedCycle, e.dest, num))
            {
                return true;
            }
        }
        if(e.dest!=par)
        {
            return true;
        }
    }
    return false;
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[1].add(new Edge(1, 4, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 5, 1));

        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 1, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 2, 1));
        graph[5].add(new Edge(5, 4, 1));

        System.out.println("BFS Traversal:");
        BFS(graph);
        System.out.println("DFS Traversal:");
        DFS(graph);
        boolean isVisitedpath[] = new boolean[graph.length];
        System.out.println(hasPath(graph, 1, 7, isVisitedpath));
        System.out.println(cycleDetection(graph));
    }
}
