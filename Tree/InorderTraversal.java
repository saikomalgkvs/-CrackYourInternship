package Tree;

import java.util.ArrayList;
import java.util.List;

/* binary tree inroder traversal */
public class InorderTraversal {
    List<Integer> list;
    InorderTraversal(){
        list = new ArrayList<>();
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return list; 
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}
