package 树;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode513 {

    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        int ans = 0;

        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(i == 0){
                    ans = poll.val;
                }

                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
            }
        }

        return ans;
    }
}
