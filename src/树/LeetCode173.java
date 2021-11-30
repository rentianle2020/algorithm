package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode173 {


}

class BSTIterator {

    List<Integer> list = new ArrayList<>();
    int index = 0;

    public BSTIterator(TreeNode root) {

        LinkedList<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            TreeNode pop = stack.pop();
            list.add(pop.val);
            root = pop.right;
        }
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return list.size() > index;
    }
}
