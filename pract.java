import java.util.ArrayList;

public class pract {
    public static class Edge{
        int src;
        int dest;
        int weight;

        Edge(int src , int dest , int weight)
        {
            this.src=src;
            
            this.dest=dest;
            this.weight=weight;
        }
    }
    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[]=new ArrayList[V];
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        graph[3].add(new Edge(3, 4, 2));
        graph[2].add(new Edge(2, 3, 1));
        for(int i=0;i<graph[2].size();i++)
        {
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }
    }
}
