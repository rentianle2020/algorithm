package 代码随想录.数组.二分查找;

/**
 * 二分查找
 * 特征：有序数组的搜索！
 * 注意边界，左闭右闭/左闭右开
 */
public class LeetCode704 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
