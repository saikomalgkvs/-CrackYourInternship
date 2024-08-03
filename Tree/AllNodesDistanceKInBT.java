// All Nodes Distance K in Binary Tree
// Problem link:
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllNodesDistanceKInBT {
    int depth = 0; // depth at which target is found from root node
    TreeNode targetNode = null;
    List<Integer> list; // contains all nodes at k distance from target

    AllNodesDistanceKInBT(){
        list = new ArrayList<>();
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        targetNode = find(root, target.val, 0, new Stack<Integer>(), k); 
        addNodes(targetNode, k, 0); // add nodes at k distance below the target.
        return list;
    }
    public void addNodes(TreeNode node, int k, int i){
        if(node == null) return;
        if(i==k){
            list.add(node.val);
            return;
        }
        addNodes(node.left, k, i+1);
        addNodes(node.right, k, i+1);
    }
    public TreeNode find(TreeNode node, int key, int i, Stack<Integer> stack, int k){
        if(node == null) return null;
        if(node.val == key){
            depth = i;
            return node;
        }
        
        TreeNode l = find(node.left, key, i+1, stack, k);
        TreeNode r = find(node.right, key, i+1, stack, k);

        // backtrack nodes
        int backDepth = k - (depth-i);
        if(backDepth == 0 && (l!=null || r!=null)) list.add(node.val);
        else{
            if(r!= null && l == null){
                addNodes(node.left, backDepth-1, 0);
                return r;
            }
            else if(l!= null && r == null){
                addNodes(node.right, backDepth-1, 0);
                return l;
            }
        }
        return (l==null) ? r : l;

    }
}
