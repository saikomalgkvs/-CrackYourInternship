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
class SortedArraytoBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        return func(nums, l, r);
    }
    public static TreeNode func(int[] nums, int l, int r){
        if(l>r) return null;

        int mid = (l+r)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = func(nums, l, mid-1);
        node.right = func(nums, mid+1, r);

        return node;
    }
}