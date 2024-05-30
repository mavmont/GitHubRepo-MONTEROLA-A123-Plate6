package Pl6;
import java.util.*;

public class Problem6 {
    private int numVertices;
    private int[][] adjacencyMatrix;

   
    public Problem6(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    void addEdge(int from, int to) {
        adjacencyMatrix[from][to]++;
    }

    void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numVertices1 = 5;
        Problem6 graph1 = new Problem6(numVertices1);
        int[][] edges1 = {
            {0, 1},
            {0, 2},
            {1, 2},
            {2, 0},
            {2, 2}, 
            {3, 4},
            {4, 3}, 
            {3, 4}  
        };
        for (int[] edge : edges1) {
            graph1.addEdge(edge[0], edge[1]);
        }
        System.out.println("Test Case 1:");
        graph1.printAdjacencyMatrix();
        System.out.println();
        
        int numVertices2 = 4;
        Problem6 graph2 = new Problem6(numVertices2);
        int[][] edges2 = {
            {0, 1},
            {1, 2},
            {2, 3}
        };
        for (int[] edge : edges2) {
            graph2.addEdge(edge[0], edge[1]);
        }
        System.out.println("Test Case 2:");
        graph2.printAdjacencyMatrix();
        System.out.println();

        int numVertices3 = 3;
        Problem6 graph3 = new Problem6(numVertices3);
        int[][] edges3 = {
            {0, 0},
            {1, 1},
            {2, 2}
        };
        for (int[] edge : edges3) {
            graph3.addEdge(edge[0], edge[1]);
        }
        System.out.println("Test Case 3:");
        graph3.printAdjacencyMatrix();
        System.out.println();

        int numVertices4 = 3;
        Problem6 graph4 = new Problem6(numVertices4);
        int[][] edges4 = {
            {0, 1},
            {0, 1},
            {1, 2},
            {1, 2}
        };
        for (int[] edge : edges4) {
            graph4.addEdge(edge[0], edge[1]);
        }
        System.out.println("Test Case 4:");
        graph4.printAdjacencyMatrix();
        System.out.println();

        int numVertices5 = 5;
        Problem6 graph5 = new Problem6(numVertices5);
        System.out.println("Test Case 5:");
        graph5.printAdjacencyMatrix();
        System.out.println();
    }
}
