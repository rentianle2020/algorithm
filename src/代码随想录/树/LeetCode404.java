package 代码随想录.树;

/**
 * 404. 左叶子之和
 */
public class LeetCode404 {

    int sum;

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return sum;
        traversal(root);

        return sum;
    }

    private void traversal(TreeNode root) {
        if(root == null) return;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
        }

        traversal(root.left);
        traversal(root.right);
    }
}
