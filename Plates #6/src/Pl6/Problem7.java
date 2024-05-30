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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        Problem7 graph = new Problem7(numVertices);

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        System.out.println("Enter the edges (format: vertex1 vertex2 count):");
        for (int i = 0; i < numEdges; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int count = scanner.nextInt();
            graph.addEdge(v1, v2, count);
        }

        graph.constructIncidenceMatrix();
        graph.printIncidenceMatrix();
    }
}
