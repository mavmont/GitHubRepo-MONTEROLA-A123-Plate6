package Pl6;

import java.util.*;

public class Problem4 {
    private int numVertices;
    private LinkedList<Integer>[] adjacencyList;

    public Problem4(int numVertices) {
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

    
    void printVertexDegrees() {
        for (int v = 0; v < numVertices; v++) {
            System.out.println("Degree of vertex " + v + " is " + adjacencyList[v].size());
        }
    }

   
    public static void main(String[] args) {
        
        Problem4 graph1 = new Problem4(5);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 4);
        System.out.println("Test Case 1:");
        graph1.printVertexDegrees();
        System.out.println();
        
        Problem4 graph2 = new Problem4(3);
        graph2.addEdge(0, 1);
        System.out.println("Test Case 2:");
        graph2.printVertexDegrees();
        System.out.println();

        Problem4 graph3 = new Problem4(4);
        graph3.addEdge(0, 1);
        graph3.addEdge(0, 2);
        graph3.addEdge(0, 3);
        graph3.addEdge(1, 2);
        graph3.addEdge(1, 3);
        graph3.addEdge(2, 3);
        System.out.println("Test Case 3:");
        graph3.printVertexDegrees();
        System.out.println();

        Problem4 graph4 = new Problem4(4);
        System.out.println("Test Case 4:");
        graph4.printVertexDegrees();
        System.out.println();

        Problem4 graph5 = new Problem4(6);
        graph5.addEdge(0, 1);
        graph5.addEdge(1, 2);
        graph5.addEdge(3, 4);
        System.out.println("Test Case 5:");
        graph5.printVertexDegrees();
        System.out.println();
    }
}
