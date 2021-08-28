package leetcode;

import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指offer 07
 */
public class BuildTree {

    public static void main(String[] args) {
        new BuildTree().buildTree2(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     *绝对是一个O(n^2),找每一个root都要遍历inorder[]
     * 通过提高在inorder中查找root位置，来提高整体速度
     * 最优方法提前将inorder[]的值与下标放入hashmap
     * 让查找root的速度提高到O(1),从而整体速度达到O(n)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int nodeVal = preorder[0];
        TreeNode node = new TreeNode(nodeVal);
        if(preorder.length == 1) return node; //如果只剩一个了（没有左右了），直接返回node
        int index = 0;
        for (; index < inorder.length; index++) {
            if(inorder[index] == nodeVal){
                break;
            }
        }

        node.left = buildTree(Arrays.copyOfRange(preorder,1,index + 1),Arrays.copyOfRange(inorder,0,index));
        node.right = buildTree(Arrays.copyOfRange(preorder,index + 1,preorder.length),Arrays.copyOfRange(inorder,index + 1,inorder.length));

        return node;
    }


    /**
     * 最佳方案，O(n)
     */
    HashMap<Integer,Integer> map = new HashMap<>(); //标记中序遍历
    int[] preorder; //保留先序遍历，方便递归时依据索引查看先序遍历的值

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i); //元素对应下标
        }
        this.preorder = preorder;

        return recur(0,0,preorder.length - 1);
    }

    public TreeNode recur(int root, int left, int right){
        if(left > right) return null;
        if (left == right) return new TreeNode(preorder[root]);
        TreeNode node = new TreeNode(preorder[root]);
        int index = map.get(preorder[root]);
        node.left = recur(root +1, left, index - 1);
        node.right = recur(root+(index - left) + 1, index + 1, right);

        return node;

    }
}
