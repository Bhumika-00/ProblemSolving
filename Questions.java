import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Questions {
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

    public static void BFS(ArrayList<Edge> graph[]) {
        boolean isVisited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVisited[i]) {
                utilBFS(graph, isVisited, i);
            }
        }
    }

    public static void utilBFS(ArrayList<Edge> graph[], boolean isVisited[], int num) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(num);

        while (!q1.isEmpty()) {
            int curr = q1.remove();

            if (!isVisited[curr]) {
                isVisited[curr] = true;
                System.out.print(curr + " ");
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q1.add(e.destination);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge> graph[]) {
        boolean isVisitedDFS[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVisitedDFS[i]) {
                utilDFS(graph, isVisitedDFS, i);
            }
        }
    }

    public static void utilDFS(ArrayList<Edge> graph[], boolean isVisitedDFS[], int num) {
        isVisitedDFS[num] = true;
        System.out.print(num + " ");

        for (int i = 0; i < graph[num].size(); i++) {
            Edge e = graph[num].get(i);
            if (!isVisitedDFS[e.destination]) {
                utilDFS(graph, isVisitedDFS, e.destination);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[], boolean isVisitedpath[], int source, int destination) {
        if (source == destination) {
            return true;
        }
        isVisitedpath[source] = true;
        for (int i = 0; i < graph[source].size(); i++) {
            Edge e = graph[source].get(i);

            if (!isVisitedpath[e.destination]) {
                if (hasPath(graph, isVisitedpath, e.destination, destination)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean hasCycle(ArrayList<Edge> graph[]) {
        boolean isVisitedCycle[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVisitedCycle[i]) {
                if (utilHasScycle(graph, isVisitedCycle, i, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean utilHasScycle(ArrayList<Edge> graph[], boolean isVisitedCycle[], int curr, int par) {
        isVisitedCycle[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isVisitedCycle[e.destination]) {
                if (utilHasScycle(graph, isVisitedCycle, e.destination, curr)) {
                    return true;
                }
            } else if (par != e.destination) {
                return true;
            }
        }
        return false;
    }

    public static boolean bipartite(ArrayList<Edge> graph[]) {
        Queue<Integer> q1 = new LinkedList<>();
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < color.length; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                q1.add(i);
            }

            while (!q1.isEmpty()) {
                int curr = q1.remove();
                for (int j = 0; j < graph[curr].size(); j++) {
                    Edge e = graph[curr].get(j);

                    if (color[e.destination] == -1) {
                        int nextColor = color[curr] == 0 ? 1 : 0;
                        color[e.destination] = nextColor;
                        q1.add(e.destination);
                    }

                    if (color[curr] == color[e.destination]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void inDegCal(ArrayList<Edge> graph[],int inDeg[])
    {
        for(int i=0;i<graph.length;i++)
        {
            int V = i;
            for(int j=0;j<graph[V].size();j++)
            {
                Edge e = graph[V].get(i);
                inDeg[e.destination]++;
            }
        }
    }
    public static void khanAlgo(ArrayList<Edge> graph[])
    {
        int inDeg[]=new int[graph.length];
        inDegCal(graph, inDeg);
        Queue<Integer> q1 = new LinkedList<>();
        for(int i=0;i<inDeg.length;i++)
        {
            if(inDeg[i]==0)
            {
                q1.add(i);
            }
        }

        while (!q1.isEmpty()) {
            int curr = q1.remove();
            System.out.print(curr + " ");
            for(int i=0;i<graph[curr].size();i++)
            {
                Edge e = q1.remove();
                inDeg[e.destination]--;
            }

            if(inDeg[e.destination]==-1)
            {
                q1.add(e.destination);
            }

        }

    }
    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        BFS(graph);
        System.out.println();
        System.out.println("-----------------------");
        DFS(graph);
        System.out.println();
        System.out.println("-----------------------");
        System.out.println(hasPath(graph, new boolean[graph.length], 0, 4));
        System.out.println();
        System.out.println("-----------------------");
        System.out.println(hasCycle(graph));
        System.out.println();
        System.out.println("-----------------------");
        System.out.println(bipartite(graph));

    }
}
