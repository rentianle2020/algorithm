package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode513 {

    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int res = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            res = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
            }
        }

        return res;
    }
}
