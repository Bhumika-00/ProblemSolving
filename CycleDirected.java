import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class CycleDirected {
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
public static boolean isCycle(ArrayList<Edge> graph[])
{
   boolean isVisted[]=new boolean[graph.length];
   boolean stack[]=new boolean[graph.length];
    for(int i=0;i<graph.length;i++)
    {
    if(!isVisted[i])
    {
        if(isCycleutil(graph,isVisted,stack,i))
        {
            return true;
        }
    }
    }
    return false;
}
public static boolean isCycleutil(ArrayList<Edge> graph[] , boolean isVisted[] , boolean stack[] , int curr)
{
    isVisted[curr]=true;
    stack[curr]=true;

    for(int i=0;i<graph[curr].size();i++)
    {
        Edge e = graph[curr].get(i);
        if(stack[e.destination])
        {
            return true;
        }
        if(!isVisted[e.destination])
        {
            if(isCycleutil(graph, isVisted, stack, e.destination))
            {
                return true;
            }
        }
    }
    stack[curr]=false;
    return false;
}
public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 5));
        // graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        // graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.destination);
        }
       System.out.println(isCycle(graph));
    }
}

