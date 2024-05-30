package Pl6;

import java.util.*;

public class Problem3 { // Write a java program that will determine if a graph has a cycle or not.
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
            }
            
            else if (n != parent) {
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
        
        Problem3 graph1 = new Problem3(5); // Test Case 1
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 0);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 4);
        System.out.println("Test Case 1:");
        printGraphCycleDetection(graph1);

        Problem3 graph2 = new Problem3(5); // Test Case 2
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 4);
        System.out.println("Test Case 2:");
        printGraphCycleDetection(graph2);

        Problem3 graph3 = new Problem3(4); // Test Case 3
        graph3.addEdge(0, 1);
        graph3.addEdge(0, 2);
        graph3.addEdge(0, 3);
        graph3.addEdge(1, 2);
        graph3.addEdge(1, 3);
        graph3.addEdge(2, 3);
        System.out.println("Test Case 3:");
        printGraphCycleDetection(graph3);

        Problem3 graph4 = new Problem3(6); // Test Case 4
        graph4.addEdge(0, 1);
        graph4.addEdge(1, 2);
        graph4.addEdge(2, 0);
        graph4.addEdge(3, 4);
        System.out.println("Test Case 4:");
        printGraphCycleDetection(graph4);

        Problem3 graph5 = new Problem3(3); // Test Case 5
        System.out.println("Test Case 5:");
        printGraphCycleDetection(graph5);
    }

    public static void printGraphCycleDetection(Problem3 graph) {
        if (graph.isCyclic()) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
        System.out.println();
    }
}
