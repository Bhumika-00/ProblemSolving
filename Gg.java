import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Gg {
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

    /*
     * Graph Diagram (Undirected and Weighted):
     * 
     * 2
     * 0 ------ 1
     * / \ / \
     * 4/ \4 1/ \7
     * / \ / \
     * 2 2--------3
     * \ 6 /
     * \3 \2/
     * \ /
     * \------ 4
     * 
     * Explanation of Edges (all undirected):
     * - 0 ↔ 1 (weight 2)
     * - 0 ↔ 2 (weight 4)
     * - 1 ↔ 3 (weight 7)
     * - 1 ↔ 4 (weight 1)
     * - 2 ↔ 4 (weight 3)
     * - 3 ↔ 0 (weight 5)
     * - 3 ↔ 2 (weight 6)
     * - 4 ↔ 3 (weight 2)
     */
    public static void BFS(ArrayList<Edge>[] graph) {
        boolean isvisited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isvisited[i]) {
                utilBFS(graph, isvisited, i);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int destination, boolean[] isvisited) {
        if (src == destination)
            return true;

        isvisited[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!isvisited[e.destination] && hasPath(graph, e.destination, destination, isvisited)) {
                return true;
            }
        }

        return false;
    }

    public static void DFS(ArrayList<Edge>[] graph, int curr, boolean isvisited[]) {
        for (int i = 0; i < graph.length; i++) {
            if (!isvisited[i]) {
                utilBFS(graph, isvisited, i);
            }
        }
    }

    public static void utilDFS(ArrayList<Edge>[] graph, int curr, boolean isvisited[]) {
        System.out.print(curr + " ");
        isvisited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isvisited[e.destination]) {
                utilDFS(graph, e.destination, isvisited);
            }
        }
    }

    public static void utilBFS(ArrayList<Edge>[] graph, boolean isvisited[], int num) {
        Queue<Integer> q1 = new LinkedList<>();

        q1.add(num);
        while (!q1.isEmpty()) {
            int curr = q1.remove();
            if (!isvisited[curr]) {
                System.out.print(curr + " ");
                isvisited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q1.add(e.destination);
                }
            }
        }
    }

    public static boolean cycledetection(ArrayList<Edge>[] graph)
    {boolean isvisited[] = new boolean[graph.length];

        for(int i=0;i<graph.length;i++)
        {
            if(!isvisited[i])
            {
                if(utilCycleDetection(graph,isvisited,i,-1))
                {
                    return true;
                }
            }
        }
    }
    public static boolean utilCycleDetection(ArrayList<Edge>[] graph , boolean isvisited[] , int curr , int parent)
    {
    isvisited[curr]=true;
    for(int i=0;i<graph[curr].size();i++)
    {
        Edge e = graph[curr].get(i);
        if(!isvisited[e.destination])
        {
            if(utilCycleDetection(graph, isvisited, e.destination,curr))
            {
                return true;
            }
        }
        else if(e.destination!=parent)
        {
            return true;
        }
    }
    return false;
    }
    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add undirected edges (by adding both directions)

        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 2, 4);
        addEdge(graph, 1, 3, 7);
        addEdge(graph, 1, 4, 1);
        addEdge(graph, 2, 4, 3);
        addEdge(graph, 3, 0, 5);
        addEdge(graph, 3, 2, 6);
        addEdge(graph, 4, 3, 2);

       
        printGraph(graph);
        BFS(graph);
        boolean[] isvisitedDFS = new boolean[graph.length];
        DFS(graph, 0, isvisitedDFS); 

       
        boolean[] isvisitedPath = new boolean[graph.length];
        System.out.println("Path exists from 1 to 4: " + hasPath(graph, 1, 4, isvisitedPath));

    }

   
    public static void addEdge(ArrayList<Edge>[] graph, int src, int dest, int wt) {
        graph[src].add(new Edge(src, dest, wt)); 
        graph[dest].add(new Edge(dest, src, wt)); 
    }

   
    public static void printGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + " connects to: ");
            for (Edge e : graph[i]) {
                System.out.print(e.destination + "(wt: " + e.weight + ") ");
            }
            System.out.println();
        }
    }
}
