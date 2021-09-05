package leetcode;

/**
 * 剑指offer 28
 */
public class IsSymmetric {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 空间占用太大，镜像了一个树再对比，蠢了
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true; //空根节点，标识对称
        TreeNode mirrorRoot  = new TreeNode(root.val);
        createMirror(root,mirrorRoot);
        return isSameTree(root,mirrorRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode mirrorRoot) {
        boolean leftResult = true;
        boolean rightResult = true;
        if(root.val != mirrorRoot.val) return false;
        if(root.left != null) leftResult = isSameTree(root.left,mirrorRoot.left);
        if(root.right != null) rightResult = isSameTree(root.right,mirrorRoot.right);



        return leftResult && rightResult;
    }

    private void createMirror(TreeNode root, TreeNode mirrorRoot) {
        if(root == null) return;

        mirrorRoot.left = new TreeNode(root.right == null ? -1 : root.right.val);

        mirrorRoot.right = new TreeNode(root.left == null ? -1 : root.left.val);

        createMirror(root.right,mirrorRoot.left);
        createMirror(root.left,mirrorRoot.right);
    }

    /**
     * 有主节点，初始传入左右子节点
     * 如果他俩都是null，返回true；其中一个是null另一个不是，返回false
     * 拿左节点的左，比右节点的右，反之亦然，以此类推递归
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return root1.val == root2.val && helper(root1.left, root2.right) &&
                helper(root1.right, root2.left);
    }
}
