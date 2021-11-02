package 代码随想录.树;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class LeetCode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               int[] inorder, int inLeft, int inRight) {

        if((preRight - preLeft) < 1) return null;

        if((preRight - preLeft) == 1) return new TreeNode(preorder[preLeft]);

        TreeNode node = new TreeNode(preorder[preLeft]);

        int index = 0;
        for (int i = inLeft; i < inRight; i++) {
            if(inorder[i] == node.val){
                index = i;
                break;
            }
        }

        node.left = buildTree(preorder,preLeft + 1,preLeft + (index - inLeft) + 1,
                inorder,inLeft,index);

        node.right = buildTree(preorder,preLeft + (index - inLeft) + 1,preRight,
                inorder,index + 1,inRight);

        return node;
    }
}
