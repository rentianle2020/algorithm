package 代码随想录.数组.移除元素;

/**
 * 283. 移动零
 */
public class LeetCode283 {

    public void moveZeroes(int[] nums) {

        if(nums.length == 0) return;

        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if(nums[fastIndex] != 0){
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }

        while(nums.length > slowIndex){
            nums[slowIndex] = 0;
            slowIndex++;
        }
    }
}
