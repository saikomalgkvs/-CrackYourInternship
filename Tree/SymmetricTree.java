package Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return func(root.left, root.right);
    }

    boolean func(TreeNode a, TreeNode b){
        if(a==null & b==null) return true;
        if(a==null | b==null) return false;
        if(a.val != b.val) return false;

        return func(a.left, b.right) & func(a.right, b.left);
    }
    
}
