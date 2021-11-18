package 代码随想录.动态规划;

/**
 * 494. 目标和
 */
public class LeetCode496 {

    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if((sum - target) % 2 != 0) return 0;

        int size = (sum - target)/2 + target;

        int[] dp = new int[size + 1];
        dp[0] = 1;


        for (int num : nums) {
            for (int j = size; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[size];
    }
}
