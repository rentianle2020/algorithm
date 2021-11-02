package 代码随想录.树;

public class LeetCode106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,0,inorder.length,postorder,0,postorder.length);
    }

    private TreeNode buildTree(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if((postEnd - postBegin) < 1) return null;

        int mid = postorder[postEnd - 1];

        TreeNode node = new TreeNode(mid);

        int cut = 0;
        for (int i = inBegin; i < inEnd; i++) {
            if(inorder[i] == mid) {
                cut = i;
                break;
            }
        }

        node.left = buildTree(inorder,inBegin,cut,postorder,postBegin,postBegin + (cut - inBegin));
        node.left = buildTree(inorder,cut + 1,inEnd,postorder,postBegin + (cut - inBegin),postEnd - 1);

        return node;
    }


}
