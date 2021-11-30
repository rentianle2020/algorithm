package BFS;

import java.util.*;

public class LeetCode323 {

    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<Set<Integer>> graph = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }


        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                visited[i] = true;
                bfs(i,visited,graph);
                count++;
            }
        }
        return count;


    }

    private void bfs(int i, boolean[] visited, List<Set<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            Set<Integer> neighbors = graph.get(cur);
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}
