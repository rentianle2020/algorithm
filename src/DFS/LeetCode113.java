package DFS;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        backtrack(root,targetSum);
        return res;
    }

    private void backtrack(TreeNode root, int targetSum) {

        if(root == null) return;

        if(root.left == null && root.right == null && targetSum == root.val){
            path.add(root.val);
            res.add(new ArrayList<>(path));
            return;
        }

        if(root.val <= targetSum){
            path.add(root.val);
            backtrack(root.left,targetSum - root.val);
            backtrack(root.right,targetSum - root.val);
            path.remove(path.size() - 1);
        }
    }
}
