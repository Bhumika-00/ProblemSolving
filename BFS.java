import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static class Edge{
        int src;
        int destination;
        int weight;

        Edge(int src , int destination , int weight)

        {
            this.src=src;
            this.weight=weight;
            this.destination=destination;
        }
    }

    public static void bfs(ArrayList<Edge> graph [])
    {
        Queue<Integer> q1 = new LinkedList<>();
        boolean visited[]=new boolean[graph.length];
        q1.add(0);
        while (!q1.isEmpty()) {
            int curr = q1.remove();

            if(!visited[curr])
            {
             System.out.println(curr);
             visited[curr]=true;
             for(int i=0;i<graph[curr].size();i++)
             {
                Edge e = graph[curr].get(i);
                q1.add(e.destination);
             }
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph [] , int curr , boolean visited[])
    {
        System.out.println(curr);
        visited[curr]=true;
        
        for(int i=0;i<graph[curr].size();i++)
        {
            Edge e = graph[curr].get(i);
            if(!visited[e.destination])
            {
                dfs(graph, e.destination, visited);
            }
        }
    }
    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph [] = new ArrayList[V];
        for(int i=0;i<V;i++)
        {
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 3, 1));
        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 4, 1));
        graph[2].add(new Edge(2, 0, 1));

        graph[3].add(new Edge(3, 5, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[4].add(new Edge(4, 2, 1));

        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));

        graph[6].add(new Edge(6, 5, 1));

        bfs(graph);
        dfs(graph, 0, new boolean[V]);
       
    }
}
