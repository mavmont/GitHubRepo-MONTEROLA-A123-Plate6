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
        Problem5 graph1 = new Problem5(6);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 3);
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 4);
        graph1.addEdge(2, 3);
        graph1.addEdge(4, 5);
        System.out.println("Test Case 1:");
        printBipartiteCheck(graph1);
        
        Problem5 graph2 = new Problem5(4);
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 0);
        System.out.println("Test Case 2:");
        printBipartiteCheck(graph2);

        Problem5 graph3 = new Problem5(3);
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 2);
        graph3.addEdge(2, 0);
        System.out.println("Test Case 3:");
        printBipartiteCheck(graph3);

        Problem5 graph4 = new Problem5(1);
        System.out.println("Test Case 4:");
        printBipartiteCheck(graph4);

        Problem5 graph5 = new Problem5(6);
        graph5.addEdge(0, 1);
        graph5.addEdge(1, 2);
        graph5.addEdge(3, 4);
        graph5.addEdge(4, 5);
        graph5.addEdge(5, 3);
        System.out.println("Test Case 5:");
        printBipartiteCheck(graph5);
    }

    public static void printBipartiteCheck(Problem5 graph) {
        if (graph.isBipartite()) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
        System.out.println();
    }
}
