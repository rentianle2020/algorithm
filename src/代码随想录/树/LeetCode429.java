package 代码随想录.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 */
public class LeetCode429 {

    class Node {
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

    /**
     * BFS 广度优先
     */
    /*public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root == null) return result;

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            int levelSize;
            List<Integer> levelResult;

            while(!queue.isEmpty()){
                levelSize = queue.size();
                levelResult = new ArrayList<>(levelSize);
                for (int i = 0; i < levelSize; i++) {
                    Node poll = queue.poll();
                    levelResult.add(poll.val);

                    List<Node> children = poll.children;
                    children.forEach(queue::offer);
                }
                result.add(levelResult);
            }
            return result;
    }*/

    /**
     * DFS 深度优先
     */

    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        levelOrder(root,0);

        return result;
    }

    private void levelOrder(Node node, Integer deep) {
        deep++;
        if(result.size() < deep) result.add(new ArrayList<>());

        result.get(deep - 1).add(node.val);

        for (Node child : node.children) {
            levelOrder(child,deep);
        }
    }
}
