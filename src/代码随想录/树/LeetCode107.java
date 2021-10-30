package 代码随想录.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层序遍历 II
 */
public class LeetCode107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
          List<List<Integer>> result = new LinkedList<>();
          if(root == null) return result;

          Queue<TreeNode> queue = new LinkedList<>();
          int levelSize = 0;
          List<Integer> levelList;

          queue.offer(root);
          while(!queue.isEmpty()){
              levelSize = queue.size();
              levelList = new ArrayList<>(levelSize);
              for (int i = 0; i < levelSize; i++) {
                  TreeNode poll = queue.poll();
                  levelList.add(poll.val);
                  if(poll.left != null) queue.offer(poll.left);
                  if(poll.right != null) queue.offer(poll.right);
              }
              result.add(0,levelList);
          }
          return result;

    }
}
