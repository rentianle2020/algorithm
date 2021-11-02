package 代码随想录.树;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 */
public class LeetCode257 {

    public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            if(root == null) return result;

            List<Integer> path = new ArrayList<>();
            traversal(root,result,path);

            return result;
    }

    private void traversal(TreeNode root, List<String> result,List<Integer> path) {

        path.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            result.add(sb.toString());
            return;
        }

        if(root.left != null){
            traversal(root.left,result,path);
            path.remove(path.size() - 1);
        }

        if(root.right != null){
            traversal(root.right,result,path);
            path.remove(path.size() - 1);
        }
    }
}
