package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode994 {

    public int orangesRotting(int[][] grid) {

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        int minutes = 0;
        int freshNum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) freshNum++;
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
            }
        }


        while(!queue.isEmpty()){

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();

                for (int[] dir : dirs) {
                    int row = poll[0] + dir[0];
                    int col = poll[1] + dir[1];
                    if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1){
                        grid[row][col] = 2;
                        queue.offer(new int[]{row,col});
                        freshNum--;
                        if(freshNum == 0) return minutes + 1;
                    }
                }
            }

            minutes++;
        }

        return -1;
    }
}
