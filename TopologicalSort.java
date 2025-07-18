import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
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
    public static void indegCal(ArrayList<Edge> graph[], int indeg[])
    {
        for(int i=0;i<graph.length;i++)
        {
            int V = i;
            for(int j=0;j<graph[V].size();j++)
            {
                Edge e = graph[V].get(j);

                indeg[e.destination]++;
            }


        }
    }
    public static void TopologicalSort(ArrayList<Edge> graph[])
    {
        int indeg[]=new int[graph.length];
        indegCal(graph, indeg);
        Queue<Integer> q1 = new LinkedList<>();
        for(int i=0;i<graph.length;i++)
        {
            if(indeg[i]==0)
            {
                q1.add(i);
            }
        }

        while (!q1.isEmpty()) {
            int curr = q1.remove();
            System.out.println(curr);
            for(int i=0;i<graph[curr].size();i++)
            {
                Edge e = graph[curr].get(i);
                indeg[e.destination]--;

                if(indeg[e.destination]==0)
                {
                    q1.add(e.destination);
                }
            }
        }

    }
    public static void main(String[] args) {
        int V=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[]=new ArrayList[V];
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 5, 1));
        TopologicalSort(graph);
    }
}
