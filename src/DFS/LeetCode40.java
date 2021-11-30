package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode40 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        backtrack(candidates,target,0,new boolean[candidates.length],0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int sum, boolean[] used,int startIndex) {

        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if(candidates[i] + sum > target) break;
            if(used[i] || (i != 0 && candidates[i] == candidates[i - 1] && !used[i - 1])) continue;

            path.add(candidates[i]);
            used[i] = true;
            backtrack(candidates,target,sum + candidates[i],used,i + 1);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
