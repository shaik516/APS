import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // Initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Queue for 0 indegree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        // BFS
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index++] = curr;

            for (int next : graph.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // If not all courses processed → cycle
        if (index != numCourses) {
            return new int[0];
        }

        return order;
    }
}