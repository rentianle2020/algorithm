package com.tyler;

/**
 * 最长公共子序列
 * 两个序列，有公共的子序列
 */
public class LCS {

    public static void main(String[] args) {
        System.out.println(LCS.lcs2(new int[]{1, 3, 2, 4}, new int[]{2, 4, 3, 1}));
    }

    /**
     * 时间复杂度&空间复杂度 O(m*n),两个数组的长度
     * dp(i,j)是 【nums1前i个元素】 与 【nums2前j的元素】 的最长公共子序列长度
     */
    public static int lcs(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length ; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }

    /**
     * 因为推导dp[i][j]只会用到dp[i-1][]这一行，和dp[i][j-1]
     * 所以使用滚动数组，节省空间；dp[i-1][]这一行必须完整的保存，下一行都用得到
     * 还可以进一步优化成一维数组，就一行！dp[1][j]
     */
    public static int lcs2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;
        int[][] dp = new int[2][nums2.length + 1];
        for (int i = 1; i <= nums1.length ; i++) {
            int row = i % 2;
            int prevRow = (i - 1) % 2;
            for (int j = 1; j <= nums2.length; j++) {
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[row][j] = dp[prevRow][j - 1] + 1;
                }else{
                    dp[row][j] = Math.max(dp[prevRow][j],dp[row][j - 1]);
                }
            }
        }
        return dp[nums1.length % 2][nums2.length];
    }
}
