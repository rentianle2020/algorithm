package 代码随想录.树;

/**
 * 226. 翻转二叉树
 */
public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        exchangeLeftRight(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    public void exchangeLeftRight(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
