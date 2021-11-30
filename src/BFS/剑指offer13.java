package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 剑指offer13 {

    public static void main(String[] args) {
        System.out.println(new 剑指offer13().digitSum(35, 38));
    }

    public int movingCount(int m, int n, int k) {

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        int count = 1;

        while(!queue.isEmpty() && k > 0){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int[] dir : dirs) {
                    int row = cur[0] + dir[0];
                    int col = cur[1] + dir[1];
                    int sum = digitSum(row,col);

                    if(row >= 0 && col >= 0 && row < m && col < n && !visited[row][col] && k >= sum){
                        visited[row][col] = true;
                        count++;
                        queue.offer(new int[]{row,col});
                    }
                }
            }
            k--;
        }

        return count;
    }

    private int digitSum(int a,int b){
        int sum = 0;
        while(a != 0){
            sum += a % 10;
            a /= 10;
        }

        while(b != 0){
            sum += b % 10;
            b /= 10;
        }
        System.out.println(a + " " + b + " " + sum);
        return sum;
    }
}
