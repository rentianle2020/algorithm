package 代码随想录.树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 617. 合并二叉树
 */
public class LeetCode617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        if(root2 == null) return root1;
        if(root1 == null) return root2;
        TreeNode root = new TreeNode(root1.val + root2.val);

        root.left = mergeTrees(root1.left,root2.left);
        root.right = mergeTrees(root1.right,root2.right);

        return root;
    }

    /**
     * 迭代
     */
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {

        if(root1 == null){
            return root2;
        }else if(root2 == null){
            return root1;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root2);
        stack.push(root1);

        while(!stack.isEmpty()){
            TreeNode pop1 = stack.pop();
            TreeNode pop2 = stack.pop();
            pop1.val += pop2.val;

            if(pop1.left != null && pop2.left != null){
                stack.push(pop2.left);
                stack.push(pop1.left);
            }

            if(pop1.right != null && pop2.right != null){
                stack.push(pop2.right);
                stack.push(pop1.right);
            }

            if(pop1.right == null && pop2.right != null){
                pop1.right = pop2.right;
            }

            if(pop1.left == null && pop2.left != null){
                pop1.left = pop2.left;
            }
        }
        return root1;
    }


}
