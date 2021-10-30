package 代码随想录.树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 101. 对称二叉树
 */
public class LeetCode101 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        System.out.println(new LeetCode101().isSymmetric2(treeNode));
    }

    public boolean isSymmetric(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        return isSymmetric(left,right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return isSame(left,right) &&
        isSymmetric(left.left,right.right) &&
        isSymmetric(left.right,right.left);
    }

    public boolean isSame(TreeNode left, TreeNode right){
        return left.val == right.val;
    }

    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode pollA = queue.poll();
            TreeNode pollB = queue.poll();
            if(pollA == null & pollB == null)
                continue;
            if(pollA == null || pollB == null || (pollA.val != pollB.val))
                return false;
            queue.offer(pollA.left);
            queue.offer(pollB.right);

            queue.offer(pollA.right);
            queue.offer(pollB.left);
        }
        return true;
    }
    
    
}
