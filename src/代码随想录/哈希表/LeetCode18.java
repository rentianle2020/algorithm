package 代码随想录.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 */
public class LeetCode18 {

    public static void main(String[] args) {
        new LeetCode18().fourSum(new int[]{2,2,2,2,2},8);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] > target) return lists;

            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {

                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = nums.length - 1;

                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum < target){
                        left++;
                    }else if(sum > target){
                        right--;
                    }else{
                        lists.add(Arrays.asList(nums[i] , nums[j] , nums[left] , nums[right]));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left - 1]) left++;
                        while(left < right && nums[right] == nums[right + 1]) right--;

                    }
                }
            }
        }
        return lists;
    }
}
