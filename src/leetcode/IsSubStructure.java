package leetcode;

/**
 * 剑指offer 26
 */
public class IsSubStructure {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode11 = new TreeNode(4);
        TreeNode treeNode22 = new TreeNode(1);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode11.left = treeNode22;

        System.out.println(new IsSubStructure().isSubStructure(treeNode1, treeNode11));

    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 如果两个Node.val相等，先判断A中是否包含B
     * 如果不包含，继续遍历
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;

        boolean result = false;
        result = TreeAContainsTreeB(A,B);

        if(!result){
            result = isSubStructure(A.left,B);
        }
        if(!result){
            result = isSubStructure(A.right,B);
        }
        return result;

    }

    public boolean TreeAContainsTreeB(TreeNode A,TreeNode B){
        if(B == null) return true; //一直比到B没有了，那说明相等
        if(A == null) return false; //B还有节点，而A没有了，不包含
        if(A.val != B.val) return false;
        return TreeAContainsTreeB(A.left,B.left) && TreeAContainsTreeB(A.right,B.right);
    }
}
