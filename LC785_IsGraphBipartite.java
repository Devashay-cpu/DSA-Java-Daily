import java.util.*;

public class LC785_IsGraphBipartite {

    public static boolean isBipartite(int[][] graph) {

        int n = graph.length;

        // -1 = not colored
        // 0 and 1 = two different colors
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int start = 0; start < n; start++) {

            // Handle disconnected components
            if (color[start] != -1) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();

            queue.offer(start);
            color[start] = 0;

            while (!queue.isEmpty()) {

                int node = queue.poll();

                for (int neighbor : graph[node]) {

                    // Not colored yet
                    if (color[neighbor] == -1) {

                        color[neighbor] = 1 - color[node];
                        queue.offer(neighbor);

                    }
                    // Same color on both ends → not bipartite
                    else if (color[neighbor] == color[node]) {

                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] graph = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };

        System.out.println(isBipartite(graph));
    }
}