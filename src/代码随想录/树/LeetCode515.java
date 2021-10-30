package 代码随想录.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 */
public class LeetCode515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int levelSize;
        int levelMax;

        while(!queue.isEmpty()){
            levelSize = queue.size();
            levelMax = Integer.MIN_VALUE;
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();
                if(poll.val > levelMax) levelMax = poll.val;

                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
            }
            result.add(levelMax);
        }
        return result;
    }
}
