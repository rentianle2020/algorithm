package 代码随想录.贪心;

/**
 * 376. 摆动序列
 */
public class LeetCode376 {

    public int wiggleMaxLength(int[] nums) {

        int result = nums.length;

        int pre = 0;

        for (int i = 0 ; i < nums.length; i++) {
            if(i == 0){
                continue;
            }

            int diff = nums[i] - nums[i - 1];
            if(diff == 0){
                result--;
                continue;
            }
            if(diff > 0 && pre > 0 || diff < 0 && pre < 0) {
                result--;
            }else{
                pre = diff;
            }
        }

        return result;

    }
}
