package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode490 {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int[][] visited = new int[maze.length][maze[1].length];
        visited[start[0]][start[1]] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int row = poll[0];
            int col = poll[1];


            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                while(newRow >= 0 && newCol >= 0 && newRow < maze.length && newCol < maze[0].length && maze[newRow][newCol] != 1){
                    newRow += dir[0];
                    newCol += dir[1];
                }
                newRow -= dir[0];
                newCol -= dir[1];

                if(newRow == destination[0] && newCol == destination[1]) return true;
                if(visited[newRow][newCol] == 0){
                    visited[newRow][newCol] = 1;
                    queue.offer(new int[]{newRow,newCol});
                }
            }
        }
        return false;
    }
}
