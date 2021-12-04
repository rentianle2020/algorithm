package 树;

public class LeetCode270 {

    public int closestValue(TreeNode root, double target) {

        int res = Integer.MAX_VALUE;
        double min = Double.MAX_VALUE;

        while(root != null){
            if(root.val == target) return root.val;

            double value = Math.abs(target - root.val);
            if(value < min) {
                min = value;
                res = root.val;
            }

            if(root.val > target) root = root.left;
            else root = root.right;

        }

        return res;
    }
}
