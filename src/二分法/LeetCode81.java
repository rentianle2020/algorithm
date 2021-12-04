package 二分法;

public class LeetCode81 {

    public boolean search(int[] nums, int target) {

        int begin = 0,end = nums.length - 1;

        while(begin < end){
            int mid = begin + (end - begin)/2;
            if(nums[mid] == target) return true;

            if(nums[mid] == nums[begin] && nums[mid] == nums[end]){
              begin++;
              end--;
            } else if(nums[mid] <= nums[end]){
                if(target > nums[mid] && target <= nums[end]){
                    begin = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else if(nums[mid] >= nums[end]){
                if(target >= nums[begin] && target < nums[mid]){
                    end = mid - 1;
                }else{
                    begin = mid + 1;
                }
            }
        }
        return nums[begin] == target;
    }
}
