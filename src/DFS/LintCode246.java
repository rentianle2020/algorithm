package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LintCode246 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int targetSum) {

        if(root == null) return result;
        sum(root,targetSum);
        path.clear();
        binaryTreePathSum2(root.left,targetSum);

        path.clear();
        binaryTreePathSum2(root.right,targetSum);

        return result;
    }

    private void sum(TreeNode root, int targetSum) {
        if(root == null) return;
        if(root.val == targetSum){
            path.add(root.val);
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        }

        path.add(root.val);
        sum(root.left,targetSum - root.val);
        sum(root.right,targetSum - root.val);
        path.remove(path.size() - 1);
    }
}
