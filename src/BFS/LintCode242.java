package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LintCode242 {

    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            ListNode dummy = new ListNode(0);
            ListNode lastNode = dummy;

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                lastNode.next = new ListNode(poll.val);
                lastNode = lastNode.next;

                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
            }

            res.add(dummy.next);
        }
        return res;
    }
}
