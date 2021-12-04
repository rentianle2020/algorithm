package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode173 {


}

class BSTIterator {

    LinkedList<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        pushAllLeft(root);
    }

    public int next() {
        TreeNode pop = stack.pop();
        pushAllLeft(pop.right);
        return pop.val;
    }

    public boolean hasNext() {
        return stack.isEmpty();
    }

    private void pushAllLeft(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
}
