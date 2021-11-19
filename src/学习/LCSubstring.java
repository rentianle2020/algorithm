package 学习;

/**
 * 最长公共子串
 * 和子序列不同的是，子串需要是连续的
 * dp[i][j]指的是 【以nums1[i]为结尾】 和 【以nums2[j]为结尾】 的最大子串长度
 * 如果不等就是0
 */
public class LCSubstring {

    public static void main(String[] args) {
        System.out.println(new LCSubstring().lcs(new int[]{2, 3, 4, 5}, new int[]{5, 3, 4, 5}));
    }

    public int lcs(int[] nums1, int[] nums2){
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max = 0;
        for (int i = 1; i <= nums1.length ; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }
}
