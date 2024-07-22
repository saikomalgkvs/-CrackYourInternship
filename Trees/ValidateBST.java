package Trees;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {        
        return helper(root, null, null);
    }
    private boolean helper(TreeNode node, Integer min, Integer max){
        if(node == null) return true;

        if((max!=null && node.val >= max) || (min!=null && node.val <= min)) return false;
        
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
}
