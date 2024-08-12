// Problem link: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

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
public class BinaryTreeMaxPathSum {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
    private int helper(TreeNode node){
        if(node == null) return 0;

        int lsum = Math.max(0, helper(node.left));
        int rsum = Math.max(0, helper(node.right));

        max = Math.max(max, lsum + node.val + rsum);
        return Math.max(lsum, rsum) + node.val;
    }
}