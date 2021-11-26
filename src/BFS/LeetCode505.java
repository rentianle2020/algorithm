package BFS;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode505 {

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        int[][] distance = new int[maze.length][maze[0].length];

        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[start[0]][start[1]] = 0;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.offer(new int[]{start[0],start[1],0}); //row，col,到这个坐标所需的步数

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int row = poll[0];
            int col = poll[1];
            if(row == destination[0] && col == destination[1]) return distance[row][col];

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[0];
                int count = 1;
                while(newRow >= 0 && newCol >= 0 && newRow < maze.length && newCol < maze[0].length){
                    newRow += dir[0];
                    newCol += dir[1];
                }
                newRow -= dir[0];
                newCol -= dir[1];
                count--;

                if(distance[row][col] + count < distance[newRow][newCol]){
                    distance[newRow][newCol] = distance[row][col] + count;
                    queue.offer(new int[]{newRow,newCol,distance[newRow][newCol]});
                }
            }
        }
        return -1;
    }
}
