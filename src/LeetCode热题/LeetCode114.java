package LeetCode热题;


import java.util.LinkedList;

public class LeetCode114 {

    public void flatten(TreeNode root) {

        if(root == null) return;

        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.push(root);

        TreeNode father = null;

        while(!stack.isEmpty()){

            TreeNode pop = stack.pop();

            if(father != null){
                father.right = pop;
            }
            father = pop;

            if(father.right != null) stack.push(father.right);
            if(father.left != null) stack.push(father.left);

            father.left = null;
        }
    }


    TreeNode parent = null;

    public void flatten2(TreeNode root) {

        if(root == null) return;
        traversal(root);

    }

    private void traversal(TreeNode root) {

        if(root == null) return;

        if(parent != null){
            parent.right = root;
        }
        parent = root;

        TreeNode left = parent.left;
        TreeNode right = parent.right;
        parent.left = null;

        traversal(left);
        traversal(right);

    }

}
