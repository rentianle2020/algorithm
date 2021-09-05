package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指offer 34
 */
public class PathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    List<List<Integer>> pathsList = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<Integer> path = new LinkedList<>();
        sum(path, root, 0, target);
        return this.pathsList;
    }

    public void sum(List<Integer> path, TreeNode curNode, int curValue, int target) {
        if(curNode == null) return;

        if (curValue + curNode.val == target && isLeaf(curNode)) {
            path.add(curNode.val);
            pathsList.add(new LinkedList<>(path));
        }else{
            curValue += curNode.val;
            path.add(curNode.val);
            sum(path, curNode.left, curValue, target);
            sum(path, curNode.right, curValue, target);
        }
        path.remove(path.size() - 1);
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
