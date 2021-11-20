package LeetCode热题;

/**
 * 33. 搜索旋转排序数组
 */
public class LeetCode33 {

    /**
     * O(n)
     */
    public int search(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target)
                return i;
        }

        return -1;
    }

    /**
     * O(log n)
     */
    public int search2(int[] nums, int target) {

        int begin  = 0;
        int end = nums.length;

        while(begin < end){
            int mid = (begin + end) / 2;

            if(nums[mid] == target) return mid;

            if(nums[mid] < nums[end - 1]){
                if(target > nums[mid] && target < nums[end - 1]){
                    begin = mid + 1;
                }else{
                    end = mid;
                }
            }else{
                if(target >= nums[begin] && target < nums[mid]){
                    end = mid;
                }else{
                    begin = mid + 1;
                }
            }
        }

        return -1;

    }


}
