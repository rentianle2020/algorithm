package 树;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if(root == null) return res;
        path.add(root.val);
        sum += root.val;
        backtrack(root,targetSum);


        return res;
    }

    private void backtrack(TreeNode root, int targetSum) {

        if(root.left == null && root.right == null){
            if(sum == targetSum) res.add(new ArrayList<>(path));
            return;
        }

        if(root.left != null){
            path.add(root.left.val);
            sum += root.left.val;
            backtrack(root.left,targetSum);
            path.remove(path.size() - 1);
            sum -= root.left.val;
        }

        if(root.right != null){
            path.add(root.right.val);
            sum += root.right.val;
            backtrack(root.right,targetSum);
            path.remove(path.size() - 1);
            sum -= root.right.val;
        }
    }
}
