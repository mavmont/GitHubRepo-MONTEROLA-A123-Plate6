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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int numVertices = scanner.nextInt();

        int[][] adjacencyMatrix = new int[numVertices][numVertices];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        Problem2 graph = new Problem2(adjacencyMatrix);
        graph.listEdgesAndCounts();
    }
}
