package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode39 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        Arrays.sort(candidates);
        backtrack(candidates,target,0);

        return result;

    }

    private void backtrack(int[] candidates, int target, int startIndex) {

        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }

        if(sum > target) return;

        for (int i = startIndex; i < candidates.length; i++) {

            int value = candidates[i];
            path.add(value);
            sum += value;
            backtrack(candidates,target, i);
            path.remove(path.size() - 1);
            sum -= value;
        }
    }

}
