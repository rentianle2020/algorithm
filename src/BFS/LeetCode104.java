package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode104 {

    public int maxDepth(TreeNode root) {

        if(root == null) return 0;

        int depth = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
            }
        }

        return depth;
    }
}
