package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();

            if((level & 1) == 1){
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    levelList.add(0,poll.val);

                    if(poll.left != null) queue.offer(poll.left);
                    if(poll.right != null) queue.offer(poll.right);
                }
            }else{
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    levelList.add(poll.val);

                    if(poll.left != null) queue.offer(poll.left);
                    if(poll.right != null) queue.offer(poll.right);
                }
            }
            res.add(levelList);
            level++;
        }
        return res;
    }
}
