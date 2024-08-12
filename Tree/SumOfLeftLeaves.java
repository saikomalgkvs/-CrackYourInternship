package Tree;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return func(root, false);
    }
    private int func(TreeNode node, boolean isLeft){
        if(node == null) return 0;
        if(isLeft && node.left == null && node.right == null) return node.val;
        int ans = 0;
        ans += func(node.left, true);
        ans += func(node.right, false);

        return ans;
    }    
}
