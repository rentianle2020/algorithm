package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode101 {

    public boolean isSymmetric(TreeNode root) {

        if(root == null || (root.left == null && root.right == null)) return true;
        if(root.left == null || root.right == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        queue.offer(root);

        while(!queue.isEmpty()){

            TreeNode leftTree = queue.poll();
            TreeNode rightTree = queue.poll();

            if(leftTree == null && rightTree == null) continue;
            if(leftTree == null || rightTree == null || (leftTree.val != rightTree.val)) return false;


            queue.offer(leftTree.left);
            queue.offer(rightTree.right);

            queue.offer(leftTree.right);
            queue.offer(rightTree.left);
        }

        return true;
    }
}
