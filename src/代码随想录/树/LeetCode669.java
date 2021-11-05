package 代码随想录.树;

/**
 * 669. 修剪二叉搜索树
 */
public class LeetCode669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if(root.val < low){
            root = root.right;
            trimBST(root,low,high);
        }else if(root.val > low){
            root = root.left;
            trimBST(root,low,high);
        }else{
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
        }

        return root;
    }
}
