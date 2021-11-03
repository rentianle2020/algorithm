package 代码随想录.树;

/**
 * 701. 二叉搜索树中的插入操作
 */
public class LeetCode701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        traversal(root,val);
        return root;
    }

    private void traversal(TreeNode root, int val) {

        if(val > root.val){
            if(root.right != null){
                traversal(root.right,val);
            }else{
                root.right = new TreeNode(val);
            }
        }else{
            if(root.left != null){
                traversal(root.left,val);
            }else{
                root.left = new TreeNode(val);
            }
        }
    }
}
