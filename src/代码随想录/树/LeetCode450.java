package 代码随想录.树;

/**
 * 450. 删除二叉搜索树中的节点
 */
public class LeetCode450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        return traversal(root,key);
    }

    private TreeNode traversal(TreeNode root, int key) {

        if(root == null) return null;

        if(root.val == key){
            TreeNode left = root.left;
            TreeNode right = root.right;
            //找到了要删除的节点 处理
            if(root.left != null){
                root = left;
                while(left.right != null){
                    left = left.right;
                }
                left.right = right;

            }else if(root.right != null){

                root = right;
                while(right.left != null){
                    right = right.left;
                }
                right.left = left;

            }else{
                root = null;
            }

        }else if(key < root.val){
            root.left = traversal(root.left,key);
        }else{
            root.right = traversal(root.right,key);
        }

        //返回处理后的节点
        return root;
    }
}
