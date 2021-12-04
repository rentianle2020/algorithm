package 二分法;

public class LeetCode162 {

    public int findPeakElement(int[] nums) {

        int begin = 0,end = nums.length - 1;

        while(begin < end){
            int mid = begin + (end - begin)/2;
            if(nums[mid] < nums[mid - 1]){
                begin = mid + 1;
            }else{
                end = mid;
            }
        }
        return end;
    }
}
