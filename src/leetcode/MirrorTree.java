package leetcode;

/**
 * 剑指offer 27
 */
public class MirrorTree {

    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.left);

        return root;
    }
}
