package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 */
public class LeetCode216 {

    public static void main(String[] args) {
        new LeetCode216().combinationSum3(3,7);
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    Integer sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,1);
        return result;
    }

    private void backtracking(int k, int targetSum, int startIndex) {
        if(sum > targetSum) return;

        if(path.size() == k){
            if(sum == targetSum) result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking(k,targetSum,i + 1);
            sum -= path.getLast();
            path.removeLast();
        }
    }
}
