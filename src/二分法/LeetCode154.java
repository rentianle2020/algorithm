package 二分法;

public class LeetCode154 {

    public int findMin(int[] nums) {

        int begin = 0,end = nums.length - 1;


        //如果小于end，把这个结果包含进来，如果等于end，缩小右边界，因为begin还是这个数，所有不害怕丢失这个结果
        while(begin < end){
            int mid = begin + (end - begin)/2;
            if(nums[mid] > nums[end]){
                begin = mid + 1;
            }else if (nums[mid] < nums[end]){
                end = mid;
            }else if(nums[mid] == nums[end]){
                end--;
            }
        }
        return nums[begin];
    }
}
