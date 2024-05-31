package Pl6;
import java.util.*;

public class Problem1 { // Write a java program that receives a list of edges of a simple graph, the program should determine whether it is connected
                       // and find the number of connected components if it is not connected.
     private int numVertices;
    private LinkedList<Integer>[] adjacencyList;

    public Problem1(int numVertices) {
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

    void DFS(int v, boolean[] visited) {
        visited[v] = true;
        for (int n : adjacencyList[v]) {
            if (!visited[n]) {
                DFS(n, visited);
            }
        }
    }

    int countConnectedComponents() {
        boolean[] visited = new boolean[numVertices];
        int count = 0;

        for (int v = 0; v < numVertices; ++v) {
            if (!visited[v]) {
                DFS(v, visited);
                count++;
            }
        }
        return count;
    }

    boolean isConnected() {
        boolean[] visited = new boolean[numVertices];
        DFS(0, visited);

        for (boolean vertexVisited : visited) {
            if (!vertexVisited) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graph: ");
        int numVertices = scanner.nextInt();

        Problem1 graph = new Problem1(numVertices);

        System.out.print("Enter the number of edges in the graph: ");
        int numEdges = scanner.nextInt();

        System.out.println("Enter the edges (vertex pairs): ");
        for (int i = 0; i < numEdges; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(v, w);
        }

        printGraphConnectivity(graph);

        scanner.close();
    }

    public static void printGraphConnectivity(Problem1 graph) {
        if (graph.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            int numComponents = graph.countConnectedComponents();
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + numComponents);
        }
    }
}
