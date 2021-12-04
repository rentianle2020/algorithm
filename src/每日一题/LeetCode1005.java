package 每日一题;

import java.util.Arrays;

public class LeetCode1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        int i = 0;

        while(k > 0){
            nums[i] *= -1;
            k--;
            if(i + 1 < nums.length && nums[i] > nums[i + 1]){
                i++;
            }
        }

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
