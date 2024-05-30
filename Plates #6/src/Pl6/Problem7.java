package Pl6;

import java.util.*;

public class Problem7 {
    private int numVertices;
    private List<int[]> edges; 
    private int[][] incidenceMatrix;

    public Problem7(int numVertices) {
        this.numVertices = numVertices;
        this.edges = new ArrayList<>();
    }

    void addEdge(int v1, int v2, int count) {
        for (int i = 0; i < count; i++) {
            edges.add(new int[]{v1, v2});
        }
    }

    void constructIncidenceMatrix() {
        int numEdges = edges.size();
        incidenceMatrix = new int[numVertices][numEdges];

        for (int edgeIndex = 0; edgeIndex < numEdges; edgeIndex++) {
            int[] edge = edges.get(edgeIndex);
            int v1 = edge[0];
            int v2 = edge[1];

            incidenceMatrix[v1][edgeIndex] = 1;
            incidenceMatrix[v2][edgeIndex] = 1;
        }
    }

    void printIncidenceMatrix() {
        System.out.println("Incidence Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < incidenceMatrix[0].length; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numVertices1 = 5;
        Problem7 graph1 = new Problem7(numVertices1);
        int[][] edges1 = {
            {0, 1, 1},
            {0, 2, 2},
            {1, 2, 1},
            {2, 3, 1},
            {3, 4, 1}
        };
        for (int[] edge : edges1) {
            graph1.addEdge(edge[0], edge[1], edge[2]);
        }
        graph1.constructIncidenceMatrix();
        System.out.println("Test Case 1:");
        graph1.printIncidenceMatrix();
        System.out.println();

        int numVertices2 = 4;
        Problem7 graph2 = new Problem7(numVertices2);
        int[][] edges2 = {
            {0, 1, 1},
            {1, 2, 1},
            {2, 3, 1}
        };
        for (int[] edge : edges2) {
            graph2.addEdge(edge[0], edge[1], edge[2]);
        }
        graph2.constructIncidenceMatrix();
        System.out.println("Test Case 2:");
        graph2.printIncidenceMatrix();
        System.out.println();

        int numVertices3 = 3;
        Problem7 graph3 = new Problem7(numVertices3);
        int[][] edges3 = {
            {0, 1, 2},
            {1, 2, 3}
        };
        for (int[] edge : edges3) {
            graph3.addEdge(edge[0], edge[1], edge[2]);
        }
        graph3.constructIncidenceMatrix();
        System.out.println("Test Case 3:");
        graph3.printIncidenceMatrix();
        System.out.println();

        int numVertices4 = 3;
        Problem7 graph4 = new Problem7(numVertices4);
        int[][] edges4 = {
            {0, 0, 1},
            {1, 1, 2},
            {2, 2, 1}
        };
        for (int[] edge : edges4) {
            graph4.addEdge(edge[0], edge[1], edge[2]);
        }
        graph4.constructIncidenceMatrix();
        System.out.println("Test Case 4:");
        graph4.printIncidenceMatrix();
        System.out.println();

        int numVertices5 = 5;
        Problem7 graph5 = new Problem7(numVertices5);
        graph5.constructIncidenceMatrix();
        System.out.println("Test Case 5:");
        graph5.printIncidenceMatrix();
        System.out.println();
    }
}
