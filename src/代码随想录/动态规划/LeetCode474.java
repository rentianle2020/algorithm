package 代码随想录.动态规划;

/**
 * 474. 一和零
 */
public class LeetCode474 {

    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            char[] chars = str.toCharArray();
            int zeroNum = 0;
            int oneNum = 0;

            for (char c : chars) {
                if(c == '0') zeroNum++;
                else oneNum++;
            }

            for (int i = m; i >= zeroNum ; i--) {
                for (int j = n; j >= oneNum ; j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-zeroNum][j-oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
