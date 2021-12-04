package 多指针.数组;

public class LeetCode26 {

    public int removeDuplicates(int[] nums) {

        if(nums.length == 0) return 0;

        int slow = 0;
        int fast = 0;

        while(fast < nums.length){
            if(nums[fast] == nums[slow]){
                fast++;
            }else{
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
