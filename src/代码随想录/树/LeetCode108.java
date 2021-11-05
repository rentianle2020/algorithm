package 代码随想录.树;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class LeetCode108 {

    public TreeNode sortedArrayToBST(int[] nums) {

        return findRoot(nums,0,nums.length);
    }

    private TreeNode findRoot(int[] nums, int begin, int end) {
        if((end - begin) < 1) return null;
        int index = (end + begin) >> 1;
        TreeNode root =  new TreeNode(nums[index]);

        root.left = findRoot(nums,begin,index);
        root.right = findRoot(nums,index + 1,end);

        return root;
    }
}
