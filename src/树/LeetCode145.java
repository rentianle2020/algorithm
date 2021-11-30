package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode145 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {

        if(root == null) return res;

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);

        return res;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;

        while(root != null || stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            TreeNode pop = stack.pop();
            if(pop.right != null && pop.right != pre){
                stack.push(pop);
                root = pop.right;

            }else{
                res.add(pop.val);
                pre = pop;
            }
        }

        return res;
    }
}
