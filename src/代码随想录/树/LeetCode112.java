package 代码随想录.树;

public class LeetCode112 {

    int target;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        int sum = 0;
        target = targetSum;

        return traversal(root,sum);
    }

    private boolean traversal(TreeNode root, int sum) {
        sum += root.val;

        if(root.left == null && root.right == null){
            return sum == target;
        }

        boolean left = false;
        if(root.left != null) left = traversal(root.left,sum);

        boolean right = false;
        if(root.right != null) right = traversal(root.right,sum);

        return left || right;
    }
}
