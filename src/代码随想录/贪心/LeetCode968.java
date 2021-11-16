package 代码随想录.贪心;

/**
 * 968. 监控二叉树
 */
public class LeetCode968 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    int camera = 0;

    public int minCameraCover(TreeNode root) {
        if(traversal(root) == -1) return 1;

        return camera;
    }

    private int traversal(TreeNode root) {

        //null返回-2，没有被照顾到返回-1，有照顾到返回0，放了camera返回1
        if (root == null) return -2;

        int isCameraLeft = traversal(root.left);
        int isCameraRight = traversal(root.right);

        //叶子节点
        if (isCameraLeft == -2 && isCameraRight == -2) {
            return -1;
        }else if (isCameraLeft == -1 || isCameraRight == -1) {
            camera++;
            return 1;
        } else if (isCameraLeft == 1 || isCameraRight == 1) {
            return 0;
        } else {
            return -1;
        }
    }
}
