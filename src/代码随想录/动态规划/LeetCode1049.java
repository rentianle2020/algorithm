package 代码随想录.动态规划;

/**
 * 1049. 最后一块石头的重量 II
 */
public class LeetCode1049 {

    public int lastStoneWeightII(int[] stones) {

        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int target = sum / 2;

        int[] dp = new int[target + 1];

        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j > 0; j--) {
                if(stones[i] > target) continue;
                dp[i] = Math.max(dp[j],dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - dp[target];
    }
}
