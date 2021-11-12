package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 */
public class LeetCode46 {

    List<List<Integer>> result = new LinkedList<>();

    List<Integer> path = new LinkedList<>();

    boolean[] used;


    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums);
        used = new boolean[nums.length];
        return result;
    }

    private void backtracking(int[] nums) {

        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;

            path.add(nums[i]);
            used[i] = true;
            backtracking(nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
