package 代码随想录.贪心;

/**
 * 53. 最大子序和
 */
public class LeetCode53 {

    public int maxSubArray(int[] nums) {

        int accu = 0;
        int result = Integer.MIN_VALUE;

        for (int num : nums) {
            accu += num;
            result = Math.max(result,accu);
            if(accu < 0){
                accu = 0;
            }
        }

        return result;

    }
}
