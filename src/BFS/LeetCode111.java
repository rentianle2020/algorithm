package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode111 {

    public int minDepth(TreeNode root) {

        int depth = 0;
        if(root == null) return depth;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            depth++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.left == null && poll.right == null) return depth;

                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
            }
        }

        return -1;
    }
}
