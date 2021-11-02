package 代码随想录.树;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 */
public class LeetCode98 {

    Integer max;

    public boolean isValidBST(TreeNode root) {

        if(root == null) return true;
        boolean left = isValidBST(root.left);
        if(!left) return false;

        if(max != null && root.val <= max){
            return false;
        }
        max = root.val;

        boolean right = isValidBST(root.right);
        return right;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if(root == null) return;
        traversal(root.left,list);
        list.add(root.val);
        traversal(root.right,list);

    }


}
