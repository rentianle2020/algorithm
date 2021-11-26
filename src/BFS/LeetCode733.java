package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int value = image[sr][sc];
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            int row = poll[0],col = poll[1];
            image[row][col] = newColor;

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow >= 0 && newCol >= 0 && newRow < image.length && newCol < image[0].length && image[newRow][newCol] == value){
                    queue.offer(new int[]{newRow,newCol});
                }
            }
        }

        return image;
    }
}
