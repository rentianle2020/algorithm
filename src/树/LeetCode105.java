package 树;

public class LeetCode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);

    }

    private TreeNode buildTree(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {

        TreeNode root = new TreeNode(preorder[preBegin]);

        int index = inBegin;
        for (int i = index; i <= inEnd; i++) {
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }

        int leftSize = index - inBegin;
        if(index > inBegin) root.left = buildTree(preorder,preBegin + 1,preBegin + leftSize,inorder,inBegin,index - 1);
        if(index < inEnd) root.right = buildTree(preorder,preBegin + leftSize + 1,preEnd,inorder,index + 1,inEnd);

        return root;
    }
}
