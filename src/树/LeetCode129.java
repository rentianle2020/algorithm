package 树;

public class LeetCode129 {


    public int sumNumbers(TreeNode root) {

        return sumNumbers(root,0);

    }

    private int sumNumbers(TreeNode root, int path) {
        path = path * 10 + root.val;
        if(root.left == null && root.right == null) return path;
        return root.left == null ? 0 : sumNumbers(root.left,path) + (root.right == null ? 0 : sumNumbers(root.right));
    }
}
