package BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];

        visited[0] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            Integer cur = queue.poll();
            List<Integer> list = rooms.get(cur);
            for (Integer key : list) {
                if(!visited[key]){
                    visited[key] = true;
                    queue.offer(key);
                }
            }
        }

        for (int i = 0; i < rooms.size(); i++) {
            if(!visited[i]) return false;
        }
        return true;
    }

    public TreeNode deserialize(String data) {
        if(data == null) return null;

        String[] values = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);

        int index = 1;

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(values[index] != "n"){
                cur.left = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(cur.left);
            }
            index++;
            if(values[index] != "n"){
                cur.right = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(cur.right);
            }
            index++;
        }

        return root;
    }
}
