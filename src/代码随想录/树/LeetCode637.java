package 代码随想录.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 */
public class LeetCode637 {


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int levelSize;
        double levelSum;

        while(!queue.isEmpty()){
            levelSize = queue.size();
            levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();
                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);

                levelSum += poll.val;
            }
            result.add(levelSum/levelSize);
        }
        return result;
    }

}
