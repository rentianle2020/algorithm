package 树;

public class LeetCode889 {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        return constructFromPrePost(preorder,0,preorder.length -1,preorder,0,postorder.length - 1);
    }

    private TreeNode constructFromPrePost(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {

        TreeNode root = new TreeNode(preorder[preStart]);

        int leftVal = preorder[preStart + 1];

        int leftIndex = postStart + 1;
        for(;leftIndex <= postEnd;leftIndex++){
            if(postorder[leftIndex] == leftVal) break;
        }

        int leftSize = leftIndex - postStart + 1;

        if(leftSize > 0){
            root.left = constructFromPrePost(preorder,preStart + 1,preStart + leftSize,postorder,postStart,postStart + leftSize - 1);
        }

        if(preEnd - preStart - leftSize > 0){

        root.right = constructFromPrePost(preorder,preStart + leftSize + 1,preEnd,postorder,postStart + leftSize,postEnd - 1);
        }

        return root;
    }
}
