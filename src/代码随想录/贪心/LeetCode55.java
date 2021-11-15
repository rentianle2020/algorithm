package 代码随想录.贪心;

/**
 * 55. 跳跃游戏
 */
public class LeetCode55 {

    public boolean canJump(int[] nums) {

        //从前往后
        int coverage = 0;
        for (int i = 0; i <= coverage; i++) {
            coverage = Math.max(i + nums[i],coverage);
            if(coverage >= nums.length - 1) return true;
        }
        return false;
    }


    public boolean canJump2(int[] nums){

        //从后往前
        int destination = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if((i + nums[i]) >= destination){
                destination = i;
            }
        }

        return destination == 0;
    }
}
