package Trees;

public class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root.val == p.val && dfs(root, q.val)) return p;
        if(root.val == q.val && dfs(root, p.val)) return q;

        int min = (p.val < q.val)? p.val : q.val;
        int max = (p.val > q.val)? p.val : q.val;
        if(root.val > min && root.val < max && dfs(root.left, min) && dfs(root.right, max)) return root;

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        if(l!= null) return l;
        return lowestCommonAncestor(root.right, p, q);
    }
    public boolean dfs(TreeNode node, int key){
        if(node == null) return false;
        if(node.val == key) return true;
        if(node.val > key) return dfs(node.left, key);
        else return dfs(node.right, key);
    }
}
