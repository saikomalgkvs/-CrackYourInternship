package Trees;

public class FlattenBTtoLL {
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        flatten(root.left);
        flatten(root.right);

        if(root.right == null){
            root.right = root.left;
            root.left = null;
        }
        else if(root.left == null){}
        else{
            TreeNode temp = root.left;
            while(temp.right!= null){
                temp = temp.right;
            }
            temp.right = root.right;
            root.right = null;
            root.right = root.left;
            root.left = null;
        }
    }
}
