package 树;

public class LeetCode236 {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if(root == null) return null;

            TreeNode left = lowestCommonAncestor(root.left,p,q);
            TreeNode right = lowestCommonAncestor(root.right,p,q);

            if(root.val == p.val || root.val == q.val || (left != null && right != null)){
                return root;
            }
            if(root.left != null) return left;
            if(root.right != null) return right;
            return null;
        }
}
