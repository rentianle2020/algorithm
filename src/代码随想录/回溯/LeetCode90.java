package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 */
public class LeetCode90 {

    List<List<Integer>> result = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        backtracking(nums,0);

        return result;
    }

    private void backtracking(int[] nums, int startIndex) {

        result.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++) {
            if(i != startIndex && nums[i] == nums[i- 1]) continue;

            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
