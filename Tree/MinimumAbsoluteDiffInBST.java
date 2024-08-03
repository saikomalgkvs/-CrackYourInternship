package Trees;

public class MinimumAbsoluteDiffInBST {
    int ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        int min = Integer.MAX_VALUE;
        if(root.left != null && root.right != null ){
            min = Math.min( root.val - max(root.left) , min(root.right) - root.val);
        }
        else if(root.left == null){
            min = min(root.right) - root.val;
        }
        else if(root.right == null){
            min = root.val - max(root.left);
        }
        ans = Math.min(ans, min);
        getMinimumDifference(root.left);
        getMinimumDifference(root.right);

        return ans;
    }
    public int max(TreeNode root){
        if(root == null) return 0;
        if(root.right == null) return root.val;
        return max(root.right);
    }
    public int min(TreeNode root){
        if(root == null) return Integer.MAX_VALUE;
        if(root.left == null) return root.val;
        return min(root.left);
    }
}
