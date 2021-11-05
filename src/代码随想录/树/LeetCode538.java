package 代码随想录.树;

/**
 * 538. 把二叉搜索树转换为累加树
 */
public class LeetCode538 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }
}
