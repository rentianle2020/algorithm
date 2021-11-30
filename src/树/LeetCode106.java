package 树;

public class LeetCode106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildTree(inorder,0,inorder.length - 1,postorder,0,postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {

        int val = postorder[postEnd];
        TreeNode node = new TreeNode(val);

        int index = inStart;
        for (; index < inEnd; index++) {
            if(inorder[index] == val) break;
        }

        int leftSize = index - inStart;
        if(index > inStart) node.left = buildTree(inorder,inStart,index - 1,postorder,postStart,postStart + leftSize - 1);
        if(index < inEnd) node.right = buildTree(inorder,index + 1,inEnd,postorder,postStart + leftSize,postEnd - 1);

        return node;
    }
}
