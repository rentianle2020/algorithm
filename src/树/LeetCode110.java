package 树;

public class LeetCode110 {

    public boolean isBalanced(TreeNode root) {

        if(root == null) return true;

        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }

    private int getHeight(TreeNode node) {
        if(node == null) return 0;

        return Math.max(getHeight(node.left),getHeight(node.right)) + 1;
    }
}
