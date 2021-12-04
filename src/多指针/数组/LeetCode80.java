package 多指针.数组;

public class LeetCode80 {

    public static void main(String[] args) {
        new LeetCode80().removeDuplicates(new int[]{1,1,1,2,2,3});
    }

    public int removeDuplicates(int[] nums) {

        if(nums.length <= 2) return nums.length;

        int slow = 2;
        int fast = 2;

        while(fast < nums.length){
            if(nums[fast] != nums[slow - 2]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

}
