package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 47. 全排列 II
 */
public class LeetCode47 {

    public static void main(String[] args) {
        new LeetCode47().permuteUnique(new int[]{1,1,2});
    }
    
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    boolean[] usedIndex;

    public List<List<Integer>> permuteUnique(int[] nums) {
        usedIndex = new boolean[nums.length];

        backtracking(nums);
        
        return result;
    }

    private void backtracking(int[] nums) {
        
        if(nums.length == path.size()){
            result.add(new ArrayList<>(path));
            return;
        }

        int[] usedNum = new int[21];

        for (int i = 0; i < nums.length; i++) {
            if(usedNum[nums[i] + 10] == 1) continue;
            if(usedIndex[i]) continue;

            usedNum[nums[i] + 10] = 1;
            usedIndex[i] = true;
            path.add(nums[i]);
            backtracking(nums);

            path.remove(path.size() - 1);
            usedIndex[i] = false;
        }
    }
}
