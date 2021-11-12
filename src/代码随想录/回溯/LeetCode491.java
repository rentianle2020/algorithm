package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 491. 递增子序列
 */
public class LeetCode491 {

    public static void main(String[] args) {
        new LeetCode491().findSubsequences(new int[]{4,4,3,2,1});
    }

    List<List<Integer>> result = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        backtracking(nums,0);

        return result;
    }

    private void backtracking(int[] nums, int startIndex) {

        if(path.size() > 1){
            result.add(new ArrayList<>(path));
        }

        int[] used = new int[201];

        for (int i = startIndex; i < nums.length; i++) {
            if(!path.isEmpty() && nums[i] < nums[path.size() - 1] || used[nums[i] + 100] == 1) continue;

            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backtracking(nums,i + 1);
            path.remove(path.size() - 1);
        }
    }
}
