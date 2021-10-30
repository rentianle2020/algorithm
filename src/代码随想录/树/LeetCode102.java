package 代码随想录.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 */
public class LeetCode102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        queue.offer(root);
        int levelSize = 0;
        List<Integer> levelResult;

        while(!queue.isEmpty()){
            levelSize = queue.size();
            levelResult = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();
               if(poll.left != null) queue.offer(poll.left);
               if(poll.right != null) queue.offer(poll.right);
                levelResult.add(poll.val);
            }
            result.add(levelResult);
        }
        return result;
    }
}
