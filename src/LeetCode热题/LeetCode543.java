package LeetCode热题;

/**
 * 543. 二叉树的直径
 */
public class LeetCode543 {

    int maxPathLength = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getPathLength(root);

        return maxPathLength;
    }

    public int getPathLength(TreeNode root){

        if(root == null) return 0;

        if(root.left == null && root.right == null) return 1;

        int heightLeft = getPathLength(root.left);
        int heightRight = getPathLength(root.right);

        maxPathLength = Math.max(maxPathLength,heightLeft + heightRight);

        return Math.max(heightLeft,heightRight) + 1;

    }
}
