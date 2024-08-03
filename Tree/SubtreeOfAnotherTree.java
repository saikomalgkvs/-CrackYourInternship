package Trees;

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
class SubtreeOfAnotherTree {
    boolean ans = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       if(root==null) return false;

       ans = ans | dfs(root,subRoot);

       if(ans) return ans;
       
       return isSubtree(root.left, subRoot) | isSubtree(root.right, subRoot);
    }

    boolean dfs(TreeNode a, TreeNode b){
        if(a==null && b==null) return true;
        if(a==null || b==null) return false;
        if(a.val != b.val) return false;

        return dfs(a.left, b.left) && dfs(a.right, b.right);
    }
}
