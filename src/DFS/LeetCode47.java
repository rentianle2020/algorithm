package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode47 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        backtrack(nums,new boolean[nums.length]);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used) {

        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;

            path.add(nums[i]);
            used[i] = true;
            backtrack(nums,used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
