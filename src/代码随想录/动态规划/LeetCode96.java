package 代码随想录.动态规划;

/**
 * 96. 不同的二叉搜索树
 */
public class LeetCode96 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        return dp[n];
    }
}
