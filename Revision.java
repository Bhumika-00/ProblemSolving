import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Revision {
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
    
    public static void bfs(ArrayList<Edge> graph[]) {
        boolean isVistedDFS[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVistedDFS[i]) {
                utilBFS(graph, isVistedDFS, i);
            }
        }
    }

    public static void utilBFS(ArrayList<Edge> graph[], boolean isVistedDFS[], int num) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(num);
        while (!q1.isEmpty()) {
            int curr = q1.remove();
            if (!isVistedDFS[curr]) {
                isVistedDFS[curr] = true;
                System.out.print(curr + " ");
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q1.add(e.dest);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge> graph[]) {
        boolean isVistedBFS[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVistedBFS[i]) {
                utilDFS(graph, isVistedBFS, i);
            }
        }
    }

    public static void utilDFS(ArrayList<Edge> graph[], boolean isVistedBFS[], int curr) {
        isVistedBFS[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isVistedBFS[e.dest]) {
                utilDFS(graph, isVistedBFS, e.dest);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[], boolean isVistedPath[], int source, int destination) {
        if (source == destination) {
            return true;
        }
        isVistedPath[source] = true;
        for (int i = 0; i < graph[source].size(); i++) {
            Edge e = graph[source].get(i);
            if (!isVistedPath[e.dest]) {
                if (hasPath(graph, isVistedPath, e.dest, destination)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean CycleDetection(ArrayList<Edge> graph[]) {
        boolean isVistedCycle[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVistedCycle[i]) {
                if (utilCycleDetection(graph, isVistedCycle, i, -1)) {
                    return true; // only return true if a cycle is found
                }
            }
        }
        return false; // no cycle
    }

    public static boolean utilCycleDetection(ArrayList<Edge> graph[], boolean isVistedCycle[], int curr, int par) {
        isVistedCycle[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isVistedCycle[e.dest]) {
                if (utilCycleDetection(graph, isVistedCycle, e.dest, curr)) {
                    return true;
                }
            } else if (e.dest != par) {
                return true;
            }
        }
        return false;
    }

    public static boolean bipartite(ArrayList<Edge> graph[]) {
        Queue<Integer> q1 = new LinkedList<>();
        int colors[] = new int[graph.length];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = -1;
        }
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == -1) {
                colors[i] = 0;
                q1.add(i);
            }

            while (!q1.isEmpty()) {
                int curr = q1.remove();
                for (int j = 0; j < graph[curr].size(); j++) {
                    Edge e = graph[curr].get(j);
                    if (colors[e.dest] == -1) {
                        int nextColor = colors[curr] == 0 ? 1 : 0;
                        colors[e.dest] = nextColor;
                        q1.add(e.dest);
                    } else if (colors[curr] == colors[e.dest]) {
                        return false;
                    }
                }

            }
        }
        return true;
    }

    public static boolean cycle(ArrayList<Edge> graph[]) {
        boolean isVistedCycle[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVistedCycle[i]) {
                if (utilCycle(graph, isVistedCycle, stack, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean utilCycle(ArrayList<Edge> graph[], boolean isVistedCycle[], boolean stack[], int num) {
        isVistedCycle[num] = true;
        stack[num] = true;
        for (int i = 0; i < graph[num].size(); i++) {
            Edge e = graph[num].get(i);
            if (stack[e.dest]) {
                return true;
            }
            if (!isVistedCycle[e.dest]) {
                if (utilCycle(graph, isVistedCycle, stack, e.dest)) {
                    return true;
                }
            }
        }
        stack[num] = false;
        return false;
    }

    public static void topologicalSort(ArrayList<Edge> graph[]) {
        boolean isVistedSort[] = new boolean[graph.length];
        Stack<Integer> s1 = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!isVistedSort[i]) {
                utilToplogicalSort(graph, s1, isVistedSort, i);
            }
        }

        while (!s1.isEmpty()) {
            System.out.print(s1.pop());
        }
    }

    public static void utilToplogicalSort(ArrayList<Edge> graph[], Stack<Integer> s1, boolean isVistedSort[],
            int curr) {
        isVistedSort[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isVistedSort[e.dest]) {
                utilToplogicalSort(graph, s1, isVistedSort, e.dest);
            }
        }
        s1.push(curr);
    }

    public static void calindeg(ArrayList<Edge> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int V = i;
            for (int j = 0; j < graph[V].size(); j++) {
                Edge e = graph[V].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void khanAlgo(ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        calindeg(graph, indeg);
        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (indeg[i] == 0) {
                q1.add(i);
            }
        }
        while (!q1.isEmpty()) {
            int curr = q1.remove();
            System.out.println(curr);
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q1.add(e.dest);
                }
            }
        }
    }
    public static void allPath(ArrayList<Edge> graph[] , int src , int dest , String path)
    {
     if(src==dest)
     {
        System.out.println(path+dest);
        return;
     }
     for(int i=0;i<graph[src].size();i++)
     {
        Edge e = graph[src].get(i);
        allPath(graph, e.dest, dest, path+src);
     }
    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int path;

        Pair(int node , int path)
        {
            this.node=node;
            this.path=path;
        }
        public int compareTo(Pair p2)
        {
        return this.path-p2.path;
        }
    }

    public static void dikshtraAlgo(ArrayList<Edge> graph[] , int source)
    {
        int dist[]=new int[graph.length];
        boolean isVistedlalgo[]=new boolean[graph.length];

        for(int i=0;i<dist.length;i++)
        {
            if(source!=i)
            {
                dist[i]=Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!isVistedlalgo[curr.node])
            {
                isVistedlalgo[curr.node]=true;
                for(int i=0;i<graph[curr.node].size();i++)
                {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int weight = e.weight;

                    if(dist[u]+weight<dist[v])
                    {
                        dist[v]=dist[u]+weight;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for(int i=0;i<dist.length;i++)
        {
            System.out.println(dist[i]);
        }
    }
    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        // Initialize each index with an ArrayList
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges
        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 3));
        graph[1].add(new Edge(1, 3, 6));
        graph[2].add(new Edge(2, 3, 4));
        graph[3].add(new Edge(3, 4, 2));
        graph[4].add(new Edge(4, 5, 7));
        bfs(graph);
        System.out.println();
        System.out.println("--------------------------------------");
        DFS(graph);
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println(hasPath(graph, new boolean[graph.length], 0, 4));
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println(CycleDetection(graph));
        System.out.println(bipartite(graph));
        System.out.println(cycle(graph));
        System.out.println();
        System.out.println("--------------------------------------");
        topologicalSort(graph);
        System.out.println();
        System.out.println("--------------------------------------");
        khanAlgo(graph);
        System.out.println();
        System.out.println("--------------------------------------");
        allPath(graph, 0, 3, "");
        System.out.println();
        System.out.println("--------------------------------------");
        dikshtraAlgo(graph, 0);
    }
}
