package 树;


public class LeetCode104 {

    public int maxDepth(TreeNode root) {

        if(root == null) return 0;
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax,rightMax) + 1;

    }
}
