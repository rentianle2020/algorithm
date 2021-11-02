package 代码随想录.树;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 113. 路径总和 II
 */
public class LeetCode113 {

    int target;
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return result;

        target = targetSum;
        List<Integer> path = new ArrayList<>();
        traversal(root,path,0);
        return result;
    }

    private void traversal(TreeNode root, List<Integer> path, int sum) {
        sum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null){
            if(sum == target){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        if(root.left != null){
            traversal(root.left,path,sum);
            path.remove(path.size() - 1);
        }

        if(root.right != null){
            traversal(root.right,path,sum);
            path.remove(path.size() - 1);
        }

    }

}
