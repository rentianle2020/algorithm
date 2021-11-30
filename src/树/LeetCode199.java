package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode199 {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) return ans;
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode poll = queue.poll();
                if(i == size - 1){
                    ans.add(poll.val);
                }

                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
            }
        }

        return ans;
    }
}
