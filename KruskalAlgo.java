import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgo {
    public static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.weight - e2.weight;
        }
    }

    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(int par[]) {
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        par[x] = find(par[x]);
        return par[x];
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (parA != parB) {
            if (rank[parA] < rank[parB]) {
                par[parA] = parB;
            } else if (rank[parA] > rank[parB]) {
                par[parB] = parA;
            } else {
                par[parB] = parA;
                rank[parA]++;
            }
        }
    }

    public static void kruskalAlgo(ArrayList<Edge> edges, int V) {
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;

        for (int i = 0; count < V - 1 && i < edges.size(); i++) {
            Edge e = edges.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);

            if (parA != parB) {
                union(e.src, e.dest);
                mstCost += e.weight;
                count++;
            }
        }
        System.out.println("MST cost = " + mstCost);
    }

    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));

        init(par);
        kruskalAlgo(edges, n);
    }
}
