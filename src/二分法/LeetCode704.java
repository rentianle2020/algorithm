package 二分法;

public class LeetCode704 {

    public int search(int[] nums, int target) {
        int begin = 0,end = nums.length - 1;
        while(begin <= end){
            int mid = begin + (end - begin)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target){
                end = mid - 1;
            }else{
                begin = mid + 1;
            }
        }
        return -1;
    }
}
