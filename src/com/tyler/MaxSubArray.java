package com.tyler;

import util.TimeMachine;

public class MaxSubArray {

    public static void main(String[] args) {

        TimeMachine.time("fenzhi",() ->{
            return maxSubArray(new int[]{5, -1, -3, 1, 2, 4, -2, 0});
        });
        TimeMachine.time("dp",() ->{
            return maxSubArrayDp(new int[]{5, -1, -3, 1, 2, 4, -2, 0});
        });
    }

    /**
     * 分治
     */
    static int maxSubArray(int [] nums) {
        if (nums == null || nums.length == 0) return 0;
        return maxSubArray(nums, 0, nums.length);
    }
    static int maxSubArray(int[] nums, int begin, int end) {
        // 递归基: end - begin < 2, 说明只有一个元素, nums[begin] == nums[end]
        if (end - begin < 2) return nums[begin];

        int mid = (begin + end) >> 1;

        // 最长子序列是 [i, mid) + [mid, j) 的情况
        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid - 1; i >= begin; i--) { // [i,mid)
            leftSum += nums[i];
            leftMax = Math.max(leftSum, leftMax);
        }
        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid; i < end; i++) { // [mid, end)
            rightSum += nums[i];
            rightMax = Math.max(rightSum, rightMax);
        }

        // 最长子序列在 left部分, right部分的情况
        return Math.max(leftMax + rightMax,
                Math.max(
                        maxSubArray(nums, begin, mid), 	// 最长子串在[begin, mid)的情况
                        maxSubArray(nums, mid, end) 	// 最长子串在[mid, end)的情况
                        ));
    }

    /**
     * 动态规划
     * dp(i)指的是以nums[i]结尾的最大子序列
     * if(dp(i-1)) <= 0, dp(i) = nums[i],没必要加上前边，自己当开头和结尾
     * dp(i) = Math.max(dp(i-1),dp(i-1)+nums[i],nums[i])
     */
     public static int maxSubArrayDp(int[] nums){
         if (nums == null || nums.length == 0) return 0;
         int[] dp = new int[nums.length];
         dp[0] = nums[0];
         int max = dp[0];
         for (int end = 1; end < nums.length; end++) {
             if(dp[end-1] <= 0){
                 dp[end] = nums[end];
             }else{
                 dp[end] = dp[end-1] + nums[end];
             }
             max = Math.max(dp[end],max);
         }
         return max;
     }

    /**
     * 动态规划，空间复杂度优化，dp(i)只需要用到dp(i-1)，没必要用数组
     */
    public static int maxSubArrayDp2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            if(dp < 0){
                dp = nums[i];
            }else{
                dp += nums[i];
            }
            max = Math.max(max,dp);
        }
        return max;
    }
}
