import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {

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
    public static class Pair implements Comparable<Pair>{
        int V;
        int cost;

        Pair(int V , int cost)
        {
            this.V=V;
            this.cost=cost;
        }

        @Override
        public int compareTo(Pair p2)
        {
            return this.cost-p2.cost;
        }

    }

    public static void prims(ArrayList<Edge>[] graph)
    {
        boolean isVisited[]=new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!isVisited[curr.V])
            {
                isVisited[curr.V]=true;
                finalCost += curr.cost;

                for(int i=0;i<graph[curr.V].size();i++)
                {
                    Edge e = graph[curr.V].get(i);
                    pq.add(new Pair(e.dest, e.weight));
                }
            }
        }
        System.out.println(finalCost);
    }
    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        // Initialize each ArrayList
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 3, 50));
        prims(graph);
    }
}
