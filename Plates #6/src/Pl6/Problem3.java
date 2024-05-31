package Pl6;

import java.util.*;

public class Problem3 { 
  private int numVertices;
    private LinkedList<Integer>[] adjacencyList;

    public Problem3(int numVertices) {
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

    private boolean isCyclicUtil(int v, boolean[] visited, int parent) {
        visited[v] = true;

        for (int n : adjacencyList[v]) {
            if (!visited[n]) {
                if (isCyclicUtil(n, visited, v)) {
                    return true;
                }
            } else if (n != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[numVertices];

        for (int u = 0; u < numVertices; u++) {
            if (!visited[u]) {
                if (isCyclicUtil(u, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int numVertices = scanner.nextInt();

        Problem3 graph = new Problem3(numVertices);

        System.out.print("Enter number of edges: ");
        int numEdges = scanner.nextInt();

        System.out.println("Enter edges (v1 v2):");
        for (int i = 0; i < numEdges; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            graph.addEdge(v1, v2);
        }

        printGraphCycleDetection(graph);
    }

    public static void printGraphCycleDetection(Problem3 graph) {
        if (graph.isCyclic()) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}
