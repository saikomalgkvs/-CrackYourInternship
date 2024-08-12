package Tree;

public class PathSum {
    int sum = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null) return false;

        sum += root.val;
        if(root.left == null && root.right == null && sum == targetSum){
            return true;
        }

        boolean left = hasPathSum(root.left, targetSum);
        if(left) return left;
        boolean right = hasPathSum(root.right, targetSum);
        sum -= root.val;

        return left || right;
    }    
}
