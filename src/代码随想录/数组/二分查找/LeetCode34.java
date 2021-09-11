package 代码随想录.数组.二分查找;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left <= right){
            mid = (left + right) >> 1;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid;
                while(left-1 >= 0 && nums[left-1] == nums[left]){
                    left--;
                }
                right = mid;
                while(right + 1 < nums.length && nums[right +1] == nums[right]){
                    right++;
                }
                return new int[]{left,right};
            }
        }
        return new int[]{-1,-1};
    }
}
