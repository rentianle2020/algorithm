package 代码随想录.动态规划;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 */
public class LeetCode416 {

    //回溯 超时
    int[] array = new int[2];

    public boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        int target = sum / 2;

        Arrays.fill(array,target);
        Arrays.sort(nums);
        return backtracking(nums,nums.length - 1);

    }

    private boolean backtracking(int[] nums, int curIndex) {

        if(curIndex < 0) return true;

        for (int i = 0; i < 2; i++) {
            if(array[i] == nums[curIndex] || array[i] - nums[curIndex] >= nums[0]){
                array[i] -= nums[curIndex];
                if(backtracking(nums,curIndex - 1)) return true;
                array[i] += nums[curIndex];
            }
        }

        return false;
    }

    /**
     * 01背包
     */
    public boolean canPartition2(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) return false;

        int target = sum / 2;

        int[] dp = new int[target + 1];

        for (int num : nums) {
            for (int j = target; j > 0; j--) {
                if (num > j) continue;
                dp[j] = Math.max(dp[j - num] + num, num);
            }
        }

        return dp[target] == target;
    }
}
