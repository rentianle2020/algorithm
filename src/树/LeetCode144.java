package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode144 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {

        if(root == null) return res;

        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return res;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {

        if(root == null) return res;

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            res.add(pop.val);

            if(pop.right != null ) stack.push(pop.right);
            if(pop.left != null ) stack.push(pop.left);
        }

        return res;
    }

}
