import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // Build graphs
        List<List<Integer>> redGraph = new ArrayList<>();
        List<List<Integer>> blueGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            redGraph.add(new ArrayList<>());
            blueGraph.add(new ArrayList<>());
        }

        for (int[] e : redEdges) {
            redGraph.get(e[0]).add(e[1]);
        }

        for (int[] e : blueEdges) {
            blueGraph.get(e[0]).add(e[1]);
        }

        // Result array
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // visited[node][color] → 0 = red, 1 = blue
        boolean[][] visited = new boolean[n][2];

        Queue<int[]> queue = new LinkedList<>();
        
        // Start from node 0 with both colors
        queue.offer(new int[]{0, 0}); // last was red
        queue.offer(new int[]{0, 1}); // last was blue

        visited[0][0] = true;
        visited[0][1] = true;

        int steps = 0;

        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int color = curr[1];

                if (result[node] == -1) {
                    result[node] = steps;
                }

                // Alternate color
                if (color == 0) { // last was red → go blue
                    for (int next : blueGraph.get(node)) {
                        if (!visited[next][1]) {
                            visited[next][1] = true;
                            queue.offer(new int[]{next, 1});
                        }
                    }
                } else { // last was blue → go red
                    for (int next : redGraph.get(node)) {
                        if (!visited[next][0]) {
                            visited[next][0] = true;
                            queue.offer(new int[]{next, 0});
                        }
                    }
                }
            }
            steps++;
        }

        return result;
    }
}