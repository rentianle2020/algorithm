package 树;

import java.util.*;

public class LeetCode428 {

    // Encodes a tree to a single string.
    public String serialize(Node root) {

        if(root == null) return "";
        StringBuilder stringBuilder = new StringBuilder();

        helper(root,stringBuilder);

        return stringBuilder.toString();
    }

    public void helper(Node node, StringBuilder sb){

        sb.append(node.val).append(" ");
        sb.append(node.children.size()).append(" ");

        for (Node child : node.children) {
            helper(child,sb);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {

        if(data.equals("")) return null;
        System.out.println(data);

        String[] values = data.split(" ");
        Queue<String> queue = new LinkedList<>();
        for (String value : values) {
            queue.offer(value);
        }

        return helper(queue);
    }

    public Node helper(Queue<String> queue){

        Node node = new Node(Integer.parseInt(queue.poll()));
        int childrenSize = Integer.parseInt(queue.poll());
        node.children = new ArrayList<>();

        for (int i = 0; i < childrenSize; i++) {
            node.children.add(helper(queue));
        }

        return node;
    }
}
