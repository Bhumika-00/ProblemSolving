import java.util.ArrayList;

public class Graph {
    public static class Edge{
        int src;
        int destination;
        int weight;

        Edge(int src , int destination , int weight)
        {
            this.src=src;
            this.destination=destination;
            this.weight=weight;
        }
    }
    public static void main(String[] args) {
        int V =5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[]=new ArrayList[V];

        for(int i=0;i<V;i++)
        {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        for(int i=0;i<graph[2].size();i++)
        {
            Edge e = graph[2].get(i);
            System.out.println(e.destination);
        }
        
    }
}
