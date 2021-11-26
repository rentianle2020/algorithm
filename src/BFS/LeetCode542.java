package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode542 {

    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    public int[][] updateMatrix(int[][] mat) {

        int[][] dist = new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            for (int[] dir : dirs) {
                int row = poll[0] + dir[0];
                int col = poll[1] + dir[1];
                if(row >= 0 && col >= 0 && row < mat.length && col < mat[0].length && !visited[row][col]){
                    visited[row][col] = true;
                    dist[row][col] = dist[poll[0]][poll[1]] + 1;
                    queue.offer(new int[]{row,col});
                }
            }
        }

        return dist;
    }
}
