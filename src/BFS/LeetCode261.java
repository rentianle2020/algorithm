package BFS;

import java.util.*;

public class LeetCode261 {

    public boolean validTree(int n, int[][] edges) {

        boolean[][] graph = new boolean[n][n];
        boolean[] visited = new boolean[n];

        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            for (int i = 0; i < n; i++) {
                if(graph[poll][i]){
                    graph[poll][i] = false;
                    graph[i][poll] = false;
                    if(visited[i]) return false;
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]) return false;
        }

        return true;
    }
}
