package 代码随想录.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 */
public class LeetCode513 {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int left = -1;

        queue.offer(root);
        int levelSize = 0;


        if(!queue.isEmpty()){
            levelSize = queue.size();
            left = queue.peek().val;
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();

                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.left);
            }
        }
        return left;
    }

    int deepest = -1;
    int value = 0;

    public int findBottomLeftValue2(TreeNode root) {
        findLeftValue(root,0);
        return value;
    }

    private void findLeftValue(TreeNode root, int deep) {
        if(root == null) return;
        if(deep > deepest){
            deepest = deep;
            value = root.val;
        }

        findLeftValue(root.left, deep + 1);
        findLeftValue(root.right, deep + 1);

    }
}
