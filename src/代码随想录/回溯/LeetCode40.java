package 代码随想录.回溯;

/**
 * 40. 组合总和 II
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode40 {
    
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return result;

        Arrays.sort(candidates);
        backtracking(candidates,target,0,0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int beginIndex, int sum) {

        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = beginIndex; i < candidates.length; i++) {
            if(sum + candidates[i] > target) break;
            if(i != beginIndex && candidates[i] == candidates[i] - 1) continue;

            path.add(candidates[i]);
            backtracking(candidates,target,beginIndex + 1,sum + candidates[i]);
            path.remove(path.size() - 1);

        }
    }
}
