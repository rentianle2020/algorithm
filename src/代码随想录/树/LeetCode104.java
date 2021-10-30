package 代码随想录.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 */
public class LeetCode104 {

    public int maxDepth(TreeNode root) {

        int depth = 0;
        if(root == null) return depth;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize;

        while(!queue.isEmpty()){
            depth++;
            levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();
                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
            }

        }
        return depth;

    }
}
