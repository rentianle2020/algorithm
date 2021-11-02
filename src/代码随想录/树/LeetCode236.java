package 代码随想录.树;

/**
 * 236. 二叉树的最近公共祖先
 */
public class LeetCode236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       return traversal(root,p,q);
    }

    private TreeNode traversal(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null) return root;

        TreeNode left = traversal(root.left, p, q);
        TreeNode right = traversal(root.right, p, q);

        if(left == null && right == null) return null;
        if(left != null) {
            return left;
        }
        return right;
    }
}
