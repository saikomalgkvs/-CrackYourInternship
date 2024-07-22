package Trees;

import java.util.ArrayList;
import java.util.List;

public class RecoverBST {
    class Solution {
    List<TreeNode> list;
    public void recoverTree(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        
        List<TreeNode[]> dups = new ArrayList<>();

        for(int i=0; i<list.size()-1; i++){
            TreeNode a = list.get(i);
            TreeNode b = list.get(i+1);
            if(a.val > b.val) dups.add(new TreeNode[]{a,b});
        }
        int size = dups.size();
        if(size == 1){
            TreeNode[] pair = dups.get(0);
            int temp = pair[0].val;
            pair[0].val = pair[1].val;
            pair[1].val = temp;
        }
        else if(size == 2){
            TreeNode[] pair1 = dups.get(0);
            TreeNode[] pair2 = dups.get(1);
            int temp = pair1[0].val;
            pair1[0].val = pair2[1].val;
            pair2[1].val = temp;
        }
    }
    private void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        list.add(node);
        inorder(node.right);
    }
}
}
