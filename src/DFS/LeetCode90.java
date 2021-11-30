package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(nums,0,ans,path);

        return ans;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> ans, List<Integer> path) {

        ans.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) continue;

            path.add(nums[i]);
            backtrack(nums,index + 1,ans,path);
            path.remove(path.size() - 1);
        }
    }
}
