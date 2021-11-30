package DFS;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        dfs(nums,0);

        return ans;
    }

    private void dfs(int[] nums, int startIndex) {

        if(startIndex == nums.length) return;
        ans.add(new ArrayList<>(path));



        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[startIndex]);
            dfs(nums,i + 1);
            path.remove(path.size() - 1);
        }
    }
}
