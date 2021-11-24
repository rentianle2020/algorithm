package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode116 {

    public Node connect(Node root) {

        if(root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            Node pre = null;

            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();

                if(pre != null){
                    pre.next = poll;
                }
                pre = poll;

                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
            }

            pre.next = null;
        }

        return root;
    }
}
