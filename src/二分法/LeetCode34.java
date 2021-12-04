package 二分法;

public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        int first = -1,last = -1;

        int left = 0,right = nums.length - 1;
        while(left <= right){
            int mid = left + (right- left)/2;
            if(nums[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        first = left;

        left = 0;
        right = nums.length - 1;
        while(left <= right){
            int mid = left + (right- left)/2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        last = right;

        if(first <= last && last < nums.length && nums[first] == target && nums[last] == target){
            return new int[]{first,last};
        }
        return new int[]{-1,-1};
    }
}
