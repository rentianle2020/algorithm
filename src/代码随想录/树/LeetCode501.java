package 代码随想录.树;

import java.util.ArrayList;

/**
 * 501. 二叉搜索树中的众数
 */
public class LeetCode501 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        System.out.println(new LeetCode501().findMode(node));
    }

    ArrayList<Integer> result = new ArrayList<>();

    int maxCount = 0;
    int curCount = 0;
    Integer pre;

    public int[] findMode(TreeNode root) {

        traversal(root);
        int[] finalResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }

    private void traversal(TreeNode root) {
        if(root == null) return;
        traversal(root.left);

        //计数
        if(pre == null || root.val != pre){
            curCount = 1;
        }else{
            curCount ++;
        }
        pre = root.val;

        //对比计数
        if(curCount > maxCount){
            result.clear();
            result.add(root.val);
            maxCount = curCount;
        }else if(curCount == maxCount){
            result.add(root.val);
        }

        traversal(root.right);
    }
}
