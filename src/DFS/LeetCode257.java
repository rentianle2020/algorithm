package DFS;

import java.util.ArrayList;
import java.util.List;

public class LeetCode257 {

    List<String> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        backtrack(root);
        return result;
    }

    private void backtrack(TreeNode root) {

        if(root == null) return;

        if(root.left == null && root.right == null){
            path.add(root.val);
            result.add(buildPath(path));
            path.remove(path.size() - 1);
            return;
        }

        path.add(root.val);
        backtrack(root.left);
        backtrack(root.right);


    }

    private String buildPath(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        sb.append(path.get(0));
        for (int i = 1; i < path.size(); i++) {
            sb.append("->").append(path.get(i));
        }
        return sb.toString();
    }
}
