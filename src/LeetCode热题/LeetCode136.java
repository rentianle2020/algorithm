package LeetCode热题;

/**
 * 136. 只出现一次的数字
 */
public class LeetCode136 {

    public int singleNumber(int[] nums) {


        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }
}
