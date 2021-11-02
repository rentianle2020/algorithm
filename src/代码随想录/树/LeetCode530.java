package 代码随想录.树;

/**
 * 530. 二叉搜索树的最小绝对差
 */
public class LeetCode530 {

    Integer min = Integer.MAX_VALUE;
    Integer pre;


    public int getMinimumDifference(TreeNode root) {
        if(min == 1) return 1;
        if(root.left != null){
            getMinimumDifference(root.left);
        }

        if(pre != null && (root.val - pre) < min){
            min = root.val - pre;
        }
        pre = root.val;

        if(root.right != null){
            getMinimumDifference(root.right);
        }

        return min;
    }
}
