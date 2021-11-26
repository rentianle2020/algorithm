package BFS;

import java.util.*;

public class LeetCode200 {

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    mark(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void mark(char[][] grid, int row, int col) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];

            if(r >= 0 && r < grid.length && c >= 0 && c < grid.length && grid[r][c] == '1'){
                grid[row][col] = '0';
                queue.offer(new int[]{r + 1,c});
                queue.offer(new int[]{r - 1,c});
                queue.offer(new int[]{r,c + 1});
                queue.offer(new int[]{r,c - 1});
            }
        }
    }
}
