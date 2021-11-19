package LeetCode热题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 */
public class LeetCode448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if(nums[index] < 0) continue;
            nums[index] = -nums[index];
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) result.add(i + 1);
        }

        return result;
    }
}
