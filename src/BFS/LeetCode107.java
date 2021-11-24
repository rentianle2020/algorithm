package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                level.add(poll.val);

                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
            }

            res.add(0,level);
        }

        return res;

    }
}
