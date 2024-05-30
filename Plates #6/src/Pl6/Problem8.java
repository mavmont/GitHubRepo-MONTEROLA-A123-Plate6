package Pl6;
import java.util.*;

public class Problem8 {
    private int numVertices;
    private int[][] graph1;
    private int[][] graph2;
    private boolean[] visited;
    private int[] map;

    public Problem8(int[][] graph1, int[][] graph2) {
        this.graph1 = graph1;
        this.graph2 = graph2;
        this.numVertices = graph1.length;
        this.visited = new boolean[numVertices];
        this.map = new int[numVertices];
        Arrays.fill(map, -1);
    }

    public boolean areIsomorphic() {
        return isomorphicUtil(0);
    }

    private boolean isomorphicUtil(int vertex) {
        if (vertex == numVertices) {
            return true;
        }

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && isSafe(vertex, i)) {
                visited[i] = true;
                map[vertex] = i;

                if (isomorphicUtil(vertex + 1)) {
                    return true;
                }

                visited[i] = false;
                map[vertex] = -1;
            }
        }

        return false;
    }

    private boolean isSafe(int vertex1, int vertex2) {
        for (int i = 0; i < vertex1; i++) {
            if (map[i] != -1 && graph1[vertex1][i] != graph2[vertex2][map[i]]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
        int[][] graph1a = {
            {0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };
        int[][] graph2a = {
            {0, 1, 1, 0},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {0, 1, 1, 0}
        };
        Problem8 test1 = new Problem8(graph1a, graph2a);
        System.out.println("Test Case 1: The graphs are" + (test1.areIsomorphic() ? " isomorphic." : " not isomorphic."));

        int[][] graph1b = {
            {0, 1, 1},
            {1, 0, 1},
            {1, 1, 0}
        };
        int[][] graph2b = {
            {0, 1, 1},
            {1, 0, 0},
            {1, 0, 0}
        };
        Problem8 test2 = new Problem8(graph1b, graph2b);
        System.out.println("Test Case 2: The graphs are" + (test2.areIsomorphic() ? " isomorphic." : " not isomorphic."));

        int[][] graph1c = {
            {0, 1, 1},
            {1, 0, 0},
            {1, 0, 0}
        };
        int[][] graph2c = {
            {0, 1, 1},
            {1, 0, 0},
            {1, 0, 0}
        };
        Problem8 test3 = new Problem8(graph1c, graph2c);
        System.out.println("Test Case 3: The graphs are" + (test3.areIsomorphic() ? " isomorphic." : " not isomorphic."));

        int[][] graph1d = {
            {0, 1},
            {1, 0}
        };
        int[][] graph2d = {
            {0, 1},
            {1, 0}
        };
        Problem8 test4 = new Problem8(graph1d, graph2d);
        System.out.println("Test Case 4: The graphs are" + (test4.areIsomorphic() ? " isomorphic." : " not isomorphic."));

        int[][] graph1e = {
            {0, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        };
        int[][] graph2e = {
            {0, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        };
        Problem8 test5 = new Problem8(graph1e, graph2e);
        System.out.println("Test Case 5: The graphs are" + (test5.areIsomorphic() ? " isomorphic." : " not isomorphic."));
    }
}

