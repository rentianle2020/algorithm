package 代码随想录.树;

import java.util.*;

/**
 * 145. 二叉树的后序遍历
 */
public class LeetCode145 {

    /**
     * 递归
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        traversal(root,list);

        return list;
    }

    public void traversal(TreeNode cur, List<Integer> list){
        if(cur == null) return;

        traversal(cur.left,list);

        traversal(cur.right,list);

        list.add(cur.val);
    }

    /**
     * 迭代
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        TreeNode prev = null;

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right == null || root.right == prev){
                list.add(root.val);
                prev = root;
                root = null;
            }else{
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }
}
