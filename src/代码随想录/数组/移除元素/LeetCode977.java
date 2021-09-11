package 代码随想录.数组.移除元素;

/**
 * 有序数组的平方
 */
public class LeetCode977 {

    public int[] sortedSquares(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;

        int[] sorted = new int[nums.length];
        int index = sorted.length - 1;

        while(begin <= end){
            if(nums[begin] * nums[begin] < nums[end] * nums[end]){
                sorted[index] = nums[end] * nums[end];
                end--;
            }else{
                sorted[index] = nums[begin] * nums[begin];
                begin++;
            }
            index--;
        }
        return sorted;
    }
}
