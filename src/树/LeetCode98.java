package 树;

import java.util.LinkedList;

public class LeetCode98 {

    public boolean isValidBST(TreeNode root) {

        TreeNode pre = null;
        LinkedList<TreeNode> stack = new LinkedList<>();

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            TreeNode pop = stack.pop();
            if(pre != null && pop.val < pre.val) return false;
            pre = pop;
            root = pop.right;
        }
        return true;
    }


}
