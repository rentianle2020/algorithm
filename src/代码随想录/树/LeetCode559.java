package 代码随想录.树;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * 559. N 叉树的最大深度
 */
public class LeetCode559 {

    public static void main(String[] args) {
        List<Node> children = List.of(new Node(1),new Node(2));
        Node node = new Node(3, children);
        System.out.println(new LeetCode559().maxDepth(node));
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public int maxDepth(Node root) {
        if(root == null) return 0;
        int max = 0;
        if (root.children != null) {
            for (Node child : root.children) {
                max = Math.max(maxDepth(child),max);
            }
        }
        return max + 1;
    }

    public int maxDepth2(Node root) {
        if(root == null) return 0;
        OptionalInt max = OptionalInt.empty();
        if (root.children != null) {
            max = root.children.stream().mapToInt(this::maxDepth2).max();
        }
        return max.isPresent() ? max.getAsInt() + 1 : 1;
    }
}
