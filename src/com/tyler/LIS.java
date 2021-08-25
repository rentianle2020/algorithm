package com.tyler;

/**
 * 最长上升子序列
 * [10,3,5,2,1,5,2,3] --> [2,5,7,10] --> 4
 * dp(i)指的是以i为结尾的最长上升子序列长度
 * dp(0)就是1
 * dp(i)和dp(i-1)的关系是，
 */
public class LIS {

    public static void main(String[] args) {
        System.out.println(LIS.subsequence(new int[]{10,3,2,5,1,2,3}));
    }

    public static int subsequence(int[] nums){
        int[] dp = new int[nums.length];
        int max = dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
