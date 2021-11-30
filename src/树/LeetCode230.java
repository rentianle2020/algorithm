package 树;

import java.util.LinkedList;

public class LeetCode230 {

    public int kthSmallest(TreeNode root, int k) {
        int index = 1;

        LinkedList<TreeNode> stack = new LinkedList<>();

        while(root != null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }

            TreeNode pop = stack.pop();
            if(index++ == k) return pop.val;
            root = pop.right;
        }

        return -1;
    }
}
