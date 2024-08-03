package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;

        Queue<TreeNode>  q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> level = new LinkedList<>();
            int n = q.size();
            for(int i=0; i<n; i++){
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            ans.add(level);
        }
        // System.out.println(ans);
        return ans;
    }
}
