package 代码随想录.贪心;

/**
 * 45. 跳跃游戏 II
 */
public class LeetCode45 {

    int step = 0;

    public int jump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) return 0;

        findMaxJump(nums,0,0);

        return step;
    }

    public void findMaxJump(int[] nums,int start,int end){
        step++;

        int maxCoverage = Integer.MIN_VALUE;
        for (int i = start; i <= end ; i++) {
            if(i + nums[i] >= nums.length - 1) {
                return;
            }
            maxCoverage = Math.max(i + nums[i],maxCoverage);
        }

        findMaxJump(nums,end + 1,maxCoverage);
    }
}
