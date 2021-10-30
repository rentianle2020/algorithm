package 代码随想录.树;

import java.util.*;

/**
 * 94. 二叉树的中序遍历
 */
public class LeetCode94 {

    /**
     * 递归
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        traversal(root,list);

        return list;
    }

    public void traversal(TreeNode cur,List<Integer> list){
        if(cur == null) return;

        traversal(cur.left,list);

        list.add(cur.val);

        traversal(cur.right,list);
    }

    /**
     * 迭代
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

}
