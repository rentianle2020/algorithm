package 剑指offer;

import java.util.Stack;

public class KthLargest {

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode3.left = treeNode2;
        treeNode2.left = treeNode1;
        treeNode3.right = treeNode4;

        System.out.println(new KthLargest().kthLargest(treeNode3, 1));
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.right;
            }else{
                root = stack.pop(); //最大的先弹栈
                k -= 1;
                if (k == 0 )return root.val;
                root = root.left;
            }

        }
        return -1;
    }

    int k;
    int count = 0;
    int ans;
    public int kthLargest2(TreeNode root, int k) {

        this.k = k;
        traversal(root);
        return this.ans;
    }

    public void traversal(TreeNode node){
        if(node == null) return;
        traversal(node.right);

        count++;
        if(count == k){
            this.ans = node.val;
            return;
        }

        traversal(node.left);

    }
}
