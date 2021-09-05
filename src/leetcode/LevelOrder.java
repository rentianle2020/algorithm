package leetcode;

import java.util.*;

/**
 * 剑指offer 32 - 1
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);

        t3.left = t9;
        t3.right = t20;
        t20.left = t15;
        t20.right = t7;

        new LevelOrder().levelOrder3(t3);
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        int[] treeVal = new int[1100];
        int index = 0;
        LinkedList<TreeNode> queue = new LinkedList <>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
            treeVal[index] = node.val;
            index++;
        }
        int[] newTreeVal = new int[index];
        System.arraycopy(treeVal,0,newTreeVal,0,index); //虽然浪费空间，但是速度比stream可要快多了
        return newTreeVal;
    }

    /**
     * 剑指offer 32 - 2
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return lists;

        LinkedList<TreeNode> queue = new LinkedList <>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>(queue.size());
            for (int i = queue.size(); i > 0; i--) {
                //本层全部遍历出队后，下一层的所有元素也就都入好队了
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                list.add(node.val);
            }
            lists.add(list);
        }
        return lists;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return lists;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;

        while(!queue.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            int queueSize = queue.size();
            if(level % 2 != 0){

                for (; queueSize > 0; queueSize--) {
                    TreeNode node = queue.poll();
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                    list.add(node.val);
                }
            }else{
                for (;queueSize > 0; queueSize--) {
                    TreeNode node = queue.poll();
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                    list.add(0,node.val);
                }
            }
            lists.add(list);
            level++;

        }
        return lists;
    }
}
