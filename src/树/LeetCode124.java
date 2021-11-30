package 树;

public class LeetCode124 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        getValue(root);

        return max;
    }

    private int getValue(TreeNode root) {

        if(root == null) return 0;

        int left = getValue(root.left);
        int right = getValue(root.right);
        if(left < 0) left = 0;
        if(right < 0) right = 0;

        int value = root.val + left + right;
        max = Math.max(max,value);

        return left > right ? left + root.val : right + root.val;
    }
}
