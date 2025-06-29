import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponents {
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

    // Construct the graph and return it
    public static ArrayList<Edge>[] construct() {
        int V = 9;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 5, 1));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(5, 1, 1));

        graph[4].add(new Edge(3, 2, 1));
        graph[4].add(new Edge(4, 2, 1));

        graph[5].add(new Edge(6, 8, 1));
        graph[5].add(new Edge(6, 7, 1));

        graph[6].add(new Edge(8, 6, 1));
        graph[6].add(new Edge(8, 9, 1));

        graph[7].add(new Edge(7, 6, 1));

        graph[8].add(new Edge(9, 8, 1));

        return graph;
    }
    public static void bfs(ArrayList<Edge>[] graph)
    {
        boolean isvisted[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(!isvisted[i])
            {
            utilbfs(graph, isvisted ,i);
            }
            
        }
    }
    public static void utilbfs(ArrayList<Edge>[] graph,boolean isvisted[],int start)
    {
        Queue<Integer> q1 = new LinkedList<>();
        
        
        q1.add(start);
        while (!q1.isEmpty()) {
            int curr = q1.remove();
            if(!isvisted[curr])
            {
                System.out.println(curr);
                isvisted[curr]=true;

                for(int i=0;i<graph[curr].size();i++)
                {
                    Edge e = graph[curr].get(i);
                    q1.add(e.destination);
                }
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = construct();

        System.out.println("Edges from node 2:");
        for (int i = 0; i < graph[2].size(); i++) {
            System.out.println("To node: " + graph[2].get(i).destination);
        }
        bfs(graph);
    }
}
