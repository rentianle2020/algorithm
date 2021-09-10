package 剑指offer;

public class MovingCount {

    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(2, 3, 1));
    }

    int colLength;
    int rowLength;
    int limit;
    boolean[][] visited;

    /**
     *
     * @param m 行length
     * @param n 列length
     * @param k 行列下标数位之和不能大于k
     * @return 从[0，0]开始走，最多能到达多少个格子
     */
    public int movingCount(int m, int n, int k) {
        colLength = m;
        rowLength = n;
        limit = k;
        visited = new boolean[m][n];
        return dfs(0,0);
    }

    private int dfs(int col, int row) {
        int sum = col % 10 + col/10 + row % 10 + row/10;
        if(sum > limit || col >= colLength || row >= rowLength || col < 0 || row < 0 || visited[col][row]) return 0;

        visited[col][row] = true; //能达到就不用回溯为false了
        return dfs(col +1,row)+ dfs(col -1,row) + dfs(col,row + 1) + dfs(col,row - 1) + 1;

    }
}
