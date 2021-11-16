package 代码随想录.动态规划;

/**
 * 63. 不同路径 II
 */
public class LeetCode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            if(obstacleGrid[i][0] == 1) continue;
            dp[i][0] = 1;
        }

        for (int i = 0; i < col; i++) {
            if(obstacleGrid[0][col] == 1) continue;
            dp[0][i] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[row][col];
    }
}
