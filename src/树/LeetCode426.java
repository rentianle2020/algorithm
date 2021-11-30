package 树;

import java.util.LinkedList;

public class LeetCode426 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public Node treeToDoublyList(Node root) {

        if(root == null) return null;

        LinkedList<Node> stack = new LinkedList<>();

        Node first = null;
        Node last = null;
        Node pre = null;

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(first == null){
                first = root;
                pre = root;
            }else{
                pre.right = root;
                root.left = pre;
                pre = pre.right;
            }

            last = root;
            root = root.right;

        }

        first.left = last;
        last.right = first;

        return first;
    }
}
