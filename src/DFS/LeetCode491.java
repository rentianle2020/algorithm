package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode491 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        Arrays.sort(nums);
        backtrack(nums,0);
        return res;

    }

    private void backtrack(int[] nums, int startIndex) {

        if(path.size() >= 2){
            res.add(new ArrayList<>(path));
        }

        int pre = Integer.MIN_VALUE;
        if(path.size() > 0)pre =  path.get(path.size() - 1);
        boolean[] used = new boolean[201];

        for (int i = startIndex; i < nums.length; i++) {
            if(i > startIndex && nums[i] == nums[i - 1] || used[nums[i]]) continue;

            if(nums[i] < pre) continue;

            path.add(nums[i]);
            used[nums[i] + 100] = true;
            backtrack(nums,i + 1);
            path.remove(path.size() - 1);
        }
    }
}
