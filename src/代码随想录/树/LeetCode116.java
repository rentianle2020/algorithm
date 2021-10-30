package 代码随想录.树;

import java.util.Deque;
import java.util.LinkedList;

/**
 *116. 填充每个节点的下一个右侧节点指针
 */
public class LeetCode116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root == null) return null;

        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);

        int levelSize;

        while(!deque.isEmpty()){
            levelSize = deque.size();
            Node first = null;

            for (int i = 0; i < levelSize; i++) {
                if(i == 0){
                    first = deque.poll();
                }else{
                    Node next = deque.poll();
                    first.next = next;
                    first = next;
                }
                if(first.left != null) deque.offer(first.left);
                if(first.right != null) deque.offer(first.right);
            }
        }
        return root;
    }

    /**
     * 空间复杂度O(1)的算法
     */
    public Node connect2(Node root) {

        if(root == null) return null;

        Node parent = root;

        while(parent.left != null){
            Node leftMost = parent.left;

            while(true){
                parent.left.next = parent.right;
                if(parent.next != null){
                    Node temp = parent.right;
                    parent = parent.next;
                    temp.next = parent.left;
                }else{
                    break;
                }
            }

            parent = leftMost;

        }
        return root;
    }
}
