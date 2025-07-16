import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Lab13{

    // q1. Create an empty adjacency‐list graph with v vertices
    public static ArrayList<ArrayList<Integer>> createEmptyArrayListGraph(int v) {
        ArrayList<ArrayList<Integer>> G = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            G.add(new ArrayList<>());
        }
        return G;
    }

    // q1. Add an undirected edge between u and v (no duplicate edges)
    public static void addEdgeArrayListGraph(ArrayList<ArrayList<Integer>> G, int u, int v) {
        if (!G.get(u).contains(v)) {
            G.get(u).add(v);
        }
        if (!G.get(v).contains(u)) {
            G.get(v).add(u);
        }
    }

    // q2. Convert adjacency‐matrix G (possibly weighted) to an adjacency‐list
    public static ArrayList<ArrayList<Integer>> adjMatrix2Adjlist(int[][] G) {
        int n = G.length;
        ArrayList<ArrayList<Integer>> list = createEmptyArrayListGraph(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < G[i].length; j++) {
                if (G[i][j] != 0) {
                    list.get(i).add(j);
                }
            }
        }
        return list;
    }

    // q2. Convert an adjacency‐list graph to a binary adjacency‐matrix
    public static int[][] adjlist2AdjMatrix(ArrayList<ArrayList<Integer>> G) {
        int n = G.size();
        int[][] M = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j : G.get(i)) {
                M[i][j] = 1;
            }
        }
        return M;
    }

    // q1, q2. Print an adjacency matrix
    public static void printAdjMatrix(int[][] G) {
        for (int i = 0; i < G.length; i++) {
            for (int j = 0; j < G[i].length; j++) {
                System.out.print(G[i][j] + ", ");
            }
            System.out.println();
        }
    }

    // q3. Breadth‐first search on a (weighted) adjacency matrix, starting at node_index
    public static void bfs(int[][] G, int node_index) {
        int n = G.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        visited[node_index] = true;
        q.add(node_index);

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int v = 0; v < n; v++) {
                if (G[u][v] != 0 && !visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // q1. Create graph with 3 vertices and add 3 undirected edges
        System.out.println("---q1");
        ArrayList<ArrayList<Integer>> G = createEmptyArrayListGraph(3);
        addEdgeArrayListGraph(G, 0, 1);
        addEdgeArrayListGraph(G, 0, 2);
        addEdgeArrayListGraph(G, 1, 2);
        int[][] G_adjMatrix = adjlist2AdjMatrix(G);
        printAdjMatrix(G_adjMatrix);

        // q2. Convert matrix to list and back to matrix, then print
        System.out.println("---q2");
        int[][] G1 = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };
        ArrayList<ArrayList<Integer>> G2 = adjMatrix2Adjlist(G1);
        int[][] G3 = adjlist2AdjMatrix(G2);
        printAdjMatrix(G3);

        // q3. BFS on a weighted matrix graph
        System.out.println("---q3");
        int[][] G4 = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };
        bfs(G4, 0); // Start BFS from node 0
    }
}
