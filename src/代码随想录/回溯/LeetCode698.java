package 代码随想录.回溯;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * 698. 划分为k个相等的子集
 */
public class LeetCode698 {


    int[] bucket;

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % k != 0) return false;

        int target = sum / k;

        bucket = new int[k];
        Arrays.fill(bucket,target);

        Arrays.sort(nums);

        return backtracking(nums,nums.length - 1);
    }

    private boolean backtracking(int[] nums,int curIndex) {

        if(curIndex < 0){
            return true;
        }

        for (int i = 0; i < bucket.length; i++) {
            if(bucket[i] >= nums[curIndex]){
                bucket[i] -= nums[curIndex];
                if(backtracking(nums,curIndex - 1)) return true;
                bucket[i] += nums[curIndex];
            }
        }

        return false;
    }
}
