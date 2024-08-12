package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = new TreeNode();
            int n = q.size();
            for(int i=0; i<n; i++){
                node = q.poll();
                if(node.left !=null) q.add(node.left);
                if(node.right !=null) q.add(node.right);
            }
            list.add(node.val);
        }

        return list;
    }
}
