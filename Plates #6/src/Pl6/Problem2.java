package Pl6;

import java.util.*;

public class Problem2 {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public Problem2(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.numVertices = adjacencyMatrix.length;
    }

    public void listEdgesAndCounts() {
        Map<String, Integer> edgeCountMap = new HashMap<>();

        for (int i = 0; i < numVertices; i++) {
            for (int j = i; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    String edge = i + "-" + j;
                    edgeCountMap.put(edge, edgeCountMap.getOrDefault(edge, 0) + adjacencyMatrix[i][j]);
                }
            }
        }

        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCountMap.entrySet()) {
            System.out.println("Edge " + entry.getKey() + " appears " + entry.getValue() + "x.");
        }
    }

    public static void main(String[] args) {

        int[][] adjacencyMatrix1 = {
            {0, 1, 2, 0},
            {1, 0, 1, 1},
            {2, 1, 0, 3},
            {0, 1, 3, 0}
        };
        System.out.println("Test Case 1:");
        Problem2 graph1 = new Problem2(adjacencyMatrix1);
        graph1.listEdgesAndCounts();
        System.out.println();

        int[][] adjacencyMatrix2 = {
            {0, 1, 1, 1},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 0}
        };
        System.out.println("Test Case 2:");
        Problem2 graph2 = new Problem2(adjacencyMatrix2);
        graph2.listEdgesAndCounts();
        System.out.println();

        int[][] adjacencyMatrix3 = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        System.out.println("Test Case 3:");
        Problem2 graph3 = new Problem2(adjacencyMatrix3);
        graph3.listEdgesAndCounts();
        System.out.println();
        
        int[][] adjacencyMatrix4 = {
            {0, 1, 0, 0},
            {1, 0, 0, 0},
            {0, 0, 0, 1},
            {0, 0, 1, 0}
        };
        System.out.println("Test Case 4:");
        Problem2 graph4 = new Problem2(adjacencyMatrix4);
        graph4.listEdgesAndCounts();
        System.out.println();

        int[][] adjacencyMatrix5 = {
            {0, 1, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0}
        };
        System.out.println("Test Case 5:");
        Problem2 graph5 = new Problem2(adjacencyMatrix5);
        graph5.listEdgesAndCounts();
        System.out.println();
    }
}


