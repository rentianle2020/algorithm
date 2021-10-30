package 代码随想录.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *199. 二叉树的右视图
 */
public class LeetCode199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int levelSize = 0;

        while(!queue.isEmpty()){
            levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();
                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);

                if(i == levelSize - 1) result.add(poll.val);
            }
        }
        return result;
    }
}
