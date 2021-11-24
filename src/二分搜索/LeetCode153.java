package 二分搜索;

/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class LeetCode153 {

    public int findMin(int[] nums) {

        int begin = 0, end = nums.length - 1;

        int ans = -1;

        while(begin <= end){

            int mid = begin + (end - begin)/2;

            if(nums[mid] <= nums[nums.length - 1]){
                ans = mid;
                end = mid - 1;
            }else{
                begin = mid + 1;
            }
        }

        return nums[ans];
    }

}
