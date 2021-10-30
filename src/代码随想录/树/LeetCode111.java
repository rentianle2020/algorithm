package 代码随想录.树;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 111. 二叉树的最小深度
 */
public class LeetCode111 {

    public int minDepth(TreeNode root) {

        int depth = 0;
        if(root == null) return depth;

        Deque<TreeNode> queue= new LinkedList<>();
        int levelSize;
        queue.offer(root);

        while(!queue.isEmpty()){
            depth++;
            levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();
                if(poll.left == null && poll.right == null) return depth;
                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
            }
        }
        return depth;

    }
}
