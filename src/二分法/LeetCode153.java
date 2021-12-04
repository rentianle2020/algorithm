package 二分法;

public class LeetCode153 {

    public int findMin(int[] nums) {

        int begin = 0,end = nums.length;

        int right = nums[nums.length - 1];

        while(begin <= end){
            int mid = begin + (end - begin)/2;
            if(nums[mid] > right){
                begin = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return nums[begin];
    }
}
