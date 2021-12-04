package 树;

import java.util.*;

public class LeetCode272 {

    List<Integer> res = new LinkedList<>();

    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        dfs(root,target,k);
        return res;
    }

    private void dfs(TreeNode root, double target, int k) {

        if(root == null) return;
        dfs(root.left,target,k);
        if(res.size() < k){
            res.add(root.val);
        }else{
            if(Math.abs(res.get(0) - target) > Math.abs(root.val - target)){
                res.remove(0);
                res.add(root.val);
            }else{
                return;
            }
        }
        dfs(root.right,target,k);
    }

}
