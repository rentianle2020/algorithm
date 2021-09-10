package 剑指offer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
public class Search {

    public static void main(String[] args) {
        System.out.println(new Search().search(new int[]{1, 3}, 1));
    }

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int index = binarySearch(nums, target);
        if(index == -1) return 0;

        int times = 1;
        int after = index;
        int before = index;
        int length = nums.length;
        while(after + 1 < length && nums[++after] == target){
            times++;
        }
        while(before - 1 >= 0 && nums[--before] == target){
            times++;
        }
        return times;
    }

    /**
     * 二分搜索，返回下标
     */
    public int binarySearch(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;

        while (begin <= end) {
            int mid = (begin + end) >> 1;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                return mid;
            }
        }
        return -1; //找不到
    }

    public int search2(int[] nums, int target) {
        int times = 0;
        for (int num : nums) {
            if(num == target) times++;
        }
        return times;
    }
}
