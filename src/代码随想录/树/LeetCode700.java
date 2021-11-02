package 代码随想录.树;

/**
 * 700. 二叉搜索树中的搜索
 */
public class LeetCode700 {

    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null){
            if(root.val == val) return root;
            if(val < root.val){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return null;
    }
}
