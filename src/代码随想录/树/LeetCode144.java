package 代码随想录.树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class LeetCode144 {

    /**
     * 递归
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        traversal(root,result);

        return result;
    }

    public void traversal(TreeNode cur, List<Integer> result){
        if(cur == null) return;

        result.add(cur.val);

        traversal(cur.left,result);
        traversal(cur.right,result);
    }

    /**
     * 迭代
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            list.add(pop.val);

            if(pop.right != null) stack.push(pop.right);
            if(pop.left != null) stack.push(pop.left);
        }

        return list;
    }




}

