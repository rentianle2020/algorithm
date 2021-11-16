package 代码随想录.动态规划;

/**
 * 62. 不同路径
 */
public class LeetCode62 {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][1] = 1;
        }

        for (int i = 0; i <= n; i++) {
            dp[1][n] = 1;
        }

        for (int row = 2; row <= m; row++) {
            for (int col = 2; col <= n; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }

        return dp[m][n];

    }
}
