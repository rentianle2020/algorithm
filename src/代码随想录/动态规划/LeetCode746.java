package 代码随想录.动态规划;

/**
 * 746. 使用最小花费爬楼梯
 */
public class LeetCode746 {

    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length + 1];

        dp[1] = 0;
        dp[2] = 0;

        for (int i = 3; i < cost.length + 1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }
}
