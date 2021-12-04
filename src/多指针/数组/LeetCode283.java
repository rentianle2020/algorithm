package 多指针.数组;

public class LeetCode283 {

    public void moveZeroes(int[] nums) {

        int slow = 0;
        int fast = 0;

        while(fast < nums.length){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
