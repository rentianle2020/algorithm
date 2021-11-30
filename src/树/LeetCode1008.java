package 树;

public class LeetCode1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,0,preorder.length - 1);
    }

    public TreeNode bstFromPreorder(int[] preorder,int start,int end) {

        int val = preorder[start];
        TreeNode node = new TreeNode(val);

        int index = start;
        for(;index <= end; index++){
            if(preorder[index] > val) break;
        }

        int rightSize = end - index + 1;
        if(index > start + 1) node.left = bstFromPreorder(preorder,start + 1,end - rightSize);
        if(index <= end) node.right = bstFromPreorder(preorder,end - rightSize + 1,end);

        return node;
    }
}
