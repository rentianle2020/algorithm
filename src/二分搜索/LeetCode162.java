package 二分搜索;

/**
 * 162. 寻找峰值
 */
public class LeetCode162 {

    public int findPeakElement(int[] nums) {

        if(nums.length == 1) return 0;

        int begin = 0, end = nums.length - 1;

        while(begin < end){
            int mid = begin + (end - begin)/2;

            if(nums[mid] > nums[mid + 1]){
                end = mid;
            }else{
                begin = mid + 1;
            }
        }

        return end;
    }
}
