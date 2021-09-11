package 代码随想录.数组.移除元素;

/**
 * 26. 删除有序数组中的重复项
 */
public class LeetCode26 {

    public static void main(String[] args) {
        System.out.println(new LeetCode26().removeDuplicates(new int[0]));
    }

    public int removeDuplicates(int[] nums) {
//        if(nums.length == 0 || nums.length == 1) return nums.length;

        int slowIndex = 0;
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
            if(nums[slowIndex] != nums[fastIndex]){
                slowIndex++;
                nums[slowIndex] = nums[fastIndex];
            }
        }
        return slowIndex + 1;
    }
}
