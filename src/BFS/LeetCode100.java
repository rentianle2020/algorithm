package BFS;


import java.util.LinkedList;
import java.util.Queue;

public class LeetCode100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new LinkedList<>();

        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        queue.offer(p);
        queue.offer(q);

        while(!queue.isEmpty()){
            TreeNode pollP = queue.poll();
            TreeNode pollQ = queue.poll();

            if(pollQ.val != pollP.val) return false;

            if(pollQ.left != null && pollP.left != null){
                queue.offer(pollP.left);
                queue.offer(pollQ.left);
            }else if(pollQ.left != null || pollP.left != null){
                return false;
            }

            if(pollQ.right != null && pollP.right != null){
                queue.offer(pollP.right);
                queue.offer(pollQ.right);
            }else if(pollQ.right != null || pollP.right != null){
                return false;
            }
        }
        return true;
    }
}
