import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class revising {
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

    public static void BFS(ArrayList<Edge> graph[]) {
        boolean isVisited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVisited[i]) {
                utilBFS(graph, isVisited, i);
            }
        }
    }

    public static void utilBFS(ArrayList<Edge> graph[], boolean isVisited[], int num) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(num);

        while (!q1.isEmpty()) {
            int curr = q1.remove();

            if (!isVisited[curr]) {
                isVisited[curr] = true;
                System.out.print(curr + " ");

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q1.add(e.dest);
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

    public static void utilDFS(ArrayList<Edge> graph[], boolean isVisitedDFS[], int num) {
        isVisitedDFS[num] = true;
        System.out.print(num+" ");

        for(int i=0;i<graph[num].size();i++)
        {
            Edge e = graph[num].get(i);
            if(!isVisitedDFS[e.dest])
            {
                isVisitedDFS[e.dest]=true;
                utilDFS(graph, isVisitedDFS, e.dest);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[] , boolean isVisitedPath[], int source , int destination)
    {
        if(source==destination)
        {
            return true;
        }
        isVisitedPath[source]=true;
        for(int i=0;i<graph[source].size();i++)
        {
            Edge e = graph[source].get(i);
            if(!isVisitedPath[e.dest])
            {
                if(hasPath(graph, isVisitedPath, e.dest, destination))
                {
                    return true;
                }
            }
        }
       return false; 
    }
    public static boolean cycleDetection(ArrayList<Edge> graph[])
    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        // initialize each index
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // add edges
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

        BFS(graph);
        System.err.println();
        DFS(graph);
        System.err.println();
        System.out.println(hasPath(graph, new boolean[graph.length], 0, 5));
    }
}
