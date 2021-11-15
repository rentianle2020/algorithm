package 代码随想录.贪心;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1005. K 次取反后最大化的数组和
 */
public class LeetCode1005 {

    public static void main(String[] args) {
        new LeetCode1005().largestSumAfterKNegations(new int[]{-4,-2,-3},4);
    }

    public int largestSumAfterKNegations(int[] nums, int k) {

        Arrays.sort(nums);

        int smallestIndex = 0;
        int smallestValue = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(Math.abs(nums[i]) < smallestValue){
                smallestValue = Math.abs(nums[i]);
                smallestIndex = i;
            }
        }


        for (int i = 0; i < nums.length && k > 0; i++) {
            if(nums[i] < 0){
                nums[i] = -nums[i];
                k--;
            }else{
                break;
            }
        }

        while(k > 0){
            nums[smallestIndex] = - nums[smallestIndex];
            k--;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
