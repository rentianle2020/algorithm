package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 */
public class LeetCode39 {

    public static void main(String[] args) {
        new LeetCode39().combinationSum(new int[]{2,3,6,7},7);
    }

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if(candidates == null || candidates.length == 0) return result;

            backtracking(candidates,target,0);

            return result;
    }

    private void backtracking(int[] candidates,int target, int beginIndex) {
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }else if(sum > target){
            return;
        }

        for (int i = beginIndex; i < candidates.length && target <= sum + candidates[i]; i++) {
            Integer candidate = candidates[i];

            path.add(candidate);
            sum += candidate;

            backtracking(candidates,target,i);

            path.remove(candidate);
            sum -= candidate;
        }
    }
}
