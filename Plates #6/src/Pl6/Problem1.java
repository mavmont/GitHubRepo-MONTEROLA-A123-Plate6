package Pl6;
import java.util.*;

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
      
        Problem1 graph1 = new Problem1(5); //Test Case 1
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(3, 4);
        System.out.println("Test Case 1:");
        printGraphConnectivity(graph1);

        Problem1 graph2 = new Problem1(4); //Test Case 2
        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(0, 3);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(2, 3);
        System.out.println("Test Case 2:");
        printGraphConnectivity(graph2);

        Problem1 graph3 = new Problem1(3); //Test Case 3
        System.out.println("Test Case 3:");
        printGraphConnectivity(graph3);

        Problem1 graph4 = new Problem1(6); //Test Case 4
        graph4.addEdge(0, 1);
        graph4.addEdge(1, 2);
        graph4.addEdge(2, 3);
        graph4.addEdge(3, 4);
        graph4.addEdge(4, 5);
        System.out.println("Test Case 4:");
        printGraphConnectivity(graph4);

        Problem1 graph5 = new Problem1(6); //Test Case 5
        graph5.addEdge(0, 1);
        graph5.addEdge(1, 2);
        graph5.addEdge(3, 4);
        graph5.addEdge(4, 5);
        System.out.println("Test Case 5:");
        printGraphConnectivity(graph5);
    }

    public static void printGraphConnectivity(Problem1 graph) {
        if (graph.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            int numComponents = graph.countConnectedComponents();
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + numComponents);
        }
        System.out.println();
    }
}

