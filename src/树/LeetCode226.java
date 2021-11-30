package 树;

public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {

        if(root == null) return null;

        TreeNode left = invertTree(root.left);

        root.left = invertTree(root.right);
        root.right = left;

        return root;
    }

}
