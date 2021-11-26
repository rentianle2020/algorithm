package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode297 {

    public static void main(String[] args) {
        String s = new String("1   2 ");
        String[] split = s.split(" ");

        System.out.println(split.length);
        for (String s1 : split) {
            System.out.println(s1);
        }
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){

            TreeNode poll = queue.poll();
            if(poll != null){
                sb.append(poll.val);
                queue.offer(poll.left);
                queue.offer(poll.right);
            }else{
                sb.append("n"); //占位符 代表null
            }
            sb.append(" ");

        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(" ");

        if(values[0].equals("n")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;

        while(!queue.isEmpty()){

            TreeNode poll = queue.poll();

            if(!"n".equals(values[index])){
                poll.left = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(poll.left);
            }
            index++;
            if(!"n".equals(values[index])){
                poll.right = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(poll.right);
            }
            index++;

            /*if(poll == null) continue;

            poll.left = values[index].equals("n") ? null : new TreeNode(Integer.parseInt(values[index]));
            poll.right = values[index + 1].equals("n") ? null : new TreeNode(Integer.parseInt(values[index + 1]));

            queue.offer(poll.left);
            queue.offer(poll.right);

            index += 2;*/
        }

        return root;
    }


}
