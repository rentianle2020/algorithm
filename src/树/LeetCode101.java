package 树;

public class LeetCode101 {

    public boolean isSymmetric(TreeNode root) {

        return isSymmetric(root,root);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {

        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;

        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
}
