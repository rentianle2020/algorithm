package 代码随想录.树;

/**
 * 654. 最大二叉树
 */
public class LeetCode654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums.length);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums,int begin, int end) {
        if((end - begin) < 1) return null;

        if((end - begin) == 1) return new TreeNode(nums[begin]);

        int index = maxIndex(nums, begin, end);
        TreeNode node = new TreeNode(nums[index]);

        node.left = constructMaximumBinaryTree(nums,begin,index);
        node.right = constructMaximumBinaryTree(nums,index + 1,end);

        return node;
    }

    private int maxIndex(int[] nums,int begin,int end){
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = begin; i < end; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
