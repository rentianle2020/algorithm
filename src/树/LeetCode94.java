package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode94 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        if(root == null) return res;

        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);

        return res;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {

        if(root == null) return res;

        LinkedList<TreeNode> stack = new LinkedList<>();

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            TreeNode pop = stack.pop();
            res.add(pop.val);
            root = pop.right;
        }

        return res;
    }
}
