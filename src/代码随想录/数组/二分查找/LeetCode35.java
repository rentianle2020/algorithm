package 代码随想录.数组.二分查找;

/**
 * 搜索插入位置
 * 存在返回下标，不存在返回插入位置下标
 */
public class LeetCode35 {

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return left;
    }
}
