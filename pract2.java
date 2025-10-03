import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class pract2 {
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
    public static void BFS(ArrayList<Edge> graph[])
    {
        Queue<Integer> q1 = new LinkedList<>();
        boolean isvisited[]=new boolean[graph.length];
        q1.add(0);
        while (!q1.isEmpty()) {
            int curr = q1.remove();
            if(!isvisited[curr])
            {
                System.out.println(curr);
                isvisited[curr]=true;


            }

            for(int i=0;i<graph[curr].size();i++)
            {
                Edge e = graph[curr].get(i);
                q1.add(e.dest);
            }
        }

    }
    public static void main(String[] args) {
        int V=7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[]=new ArrayList[V];
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 6, 1));
        BFS(graph);
    }
}
