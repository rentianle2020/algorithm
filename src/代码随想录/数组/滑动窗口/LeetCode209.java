package 代码随想录.数组.滑动窗口;

/**
 * 209. 长度最小的子数组
 */
public class LeetCode209 {

    public int minSubArrayLen(int target, int[] nums) {
        int maxLen = Integer.MAX_VALUE;
        int left = 0;
        int val = 0;
        for (int right = 0; right < nums.length; right++) {
            val += nums[right];
            while(val >= target){
                maxLen = Math.min(maxLen,right-left+1);
                val -= nums[left];
                left++;
            }
        }
        return maxLen == Integer.MAX_VALUE ? 0 : maxLen;
    }
}
