package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 */
public class LeetCode77 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }

    private void backtracking(int n, int k, int start) {
        if(path.size() == k){
            result.add(new ArrayList<>(path));
        }
        for (int i = start; i <= n - (k-path.size()); i++) {
            path.add(i);
            backtracking(n,k,i+1);
            path.remove(path.size()-1);
        }
    }
}
