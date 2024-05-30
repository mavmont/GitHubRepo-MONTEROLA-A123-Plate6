package Pl6;

import java.util.*;

public class Problem5 {
    private int numVertices;
    private LinkedList<Integer>[] adjacencyList;

    public Problem5(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; ++i) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v);
    }

    boolean isBipartite() {
        int[] colors = new int[numVertices];
        Arrays.fill(colors, -1);

        for (int i = 0; i < numVertices; i++) {
            if (colors[i] == -1) {
                if (!isBipartiteUtil(i, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isBipartiteUtil(int src, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        colors[src] = 1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : adjacencyList[u]) {
                if (colors[v] == -1) {
                    colors[v] = 1 - colors[u];
                    queue.add(v);
                } else if (colors[v] == colors[u]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        Problem5 graph = new Problem5(numVertices);

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        System.out.println("Enter the edges (format: v1 v2):");
        for (int i = 0; i < numEdges; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            graph.addEdge(v1, v2);
        }

        printBipartiteCheck(graph);
    }

    public static void printBipartiteCheck(Problem5 graph) {
        if (graph.isBipartite()) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}
