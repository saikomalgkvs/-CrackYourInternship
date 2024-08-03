package Tree;
/* balanced binary tree */
class BalancedBT {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return flag;
    }
    public int height(TreeNode node){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 1;

        int left = height(node.left);
        int right = height(node.right);
        if(Math.abs(left - right) > 1) flag = false; 
        return Math.max(left, right) +1;
    }
}
