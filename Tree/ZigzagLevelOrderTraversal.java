package Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;

        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);

        boolean isFirst = true;
        while(!dq.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int n = dq.size();
            if(isFirst){
                for(int i=0; i<n; i++){
                    TreeNode node = dq.removeFirst();
                    list.add(node.val);
                    if(node.left != null) dq.offerLast(node.left);
                    if(node.right != null) dq.offerLast(node.right);
                }
                isFirst = false;
            }
            else{
                for(int i=0; i<n; i++){
                    TreeNode node = dq.removeLast();
                    list.add(node.val);
                    if(node.right != null) dq.offerFirst(node.right);
                    if(node.left != null) dq.offerFirst(node.left);
                }
                isFirst = true;
            }
            ans.add(list);
        }
        // System.out.println(list);
        return ans;
    }
}
