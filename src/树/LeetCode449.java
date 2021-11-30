package 树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();

        helper(root,sb);

        return sb.toString();
    }

    private void helper(TreeNode root, StringBuilder sb) {

        if(root == null) return;

        sb.append(root.val).append(" ");

        helper(root.left,sb);
        helper(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;

        Queue<String> queue = new LinkedList<>(List.of(data.split(" ")));

        int bound = Integer.MAX_VALUE;

        return helper(queue,bound);
    }

    private TreeNode helper(Queue<String> queue, int bound) {
        if(queue.isEmpty() || Integer.parseInt(queue.peek()) > bound) return null;

        TreeNode node = new TreeNode(Integer.parseInt(queue.poll()));

        node.left = helper(queue,node.val);
        node.right = helper(queue,bound);

        return node;
    }
}
