package 代码随想录.树;

/**
 * 235. 二叉搜索树的最近公共祖先
 */
public class LeetCode235 {

    int highValue;
    int lowValue;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val > q.val){
            highValue = p.val;
            lowValue = q.val;
        }else{
            highValue = q.val;
            lowValue = p.val;
        }

        return traversal(root);
    }

    private TreeNode traversal(TreeNode root) {
        if(root == null) return null;
        if(root.val >= lowValue && root.val <= highValue) return root; //中

        TreeNode left = traversal(root.left); //左
        if(left != null) return left;

        return traversal(root.right); //右
    }

}
