package 代码随想录.动态规划;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 63. 不同路径 II
 */
public class LeetCode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[][] dp = new int[row][col];

        for (int i = 0; i < row && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < col && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[row - 1][col - 1];
    }
}
