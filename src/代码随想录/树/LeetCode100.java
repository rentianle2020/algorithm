package 代码随想录.树;

/**
 * 相同的树
 */
public class LeetCode100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        boolean left = isSameTree(p.left,q.left);
        boolean right = isSameTree(p.right,q.right);
        return left && right;
    }

}
