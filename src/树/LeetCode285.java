package 树;

import java.util.LinkedList;

public class LeetCode285 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        boolean flag = false;
        LinkedList<TreeNode> stack = new LinkedList<>();

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            TreeNode pop = stack.pop();
            if(flag) return pop;
            if(pop == p) flag = true;
            root = pop.right;
        }
        return null;
    }
}
