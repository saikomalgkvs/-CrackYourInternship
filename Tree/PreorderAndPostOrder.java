package Tree;
/* Construct Binary Tree from preorder and postorder */
public class PreorderAndPostOrder {
    int i = 0, j = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[i++]);
        if (root.val != postorder[j])
            root.left = constructFromPrePost(preorder, postorder);
        if (root.val != postorder[j])
            root.right = constructFromPrePost(preorder, postorder);
        j++;
        return root;
    }
}
