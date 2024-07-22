/* Check whether BST contains Dead End */

package Trees;

import java.util.ArrayList;
import java.util.List;

public class DeadEnd {
    static List<Integer> list;
    static List<Integer> leafs;
    
    public static boolean isDeadEnd(Node root){
        list = new ArrayList<Integer>();
        leafs = new ArrayList<Integer>();
        
        dfs(root);
        
        for(int i : leafs){
            if(i != 1 && i != 10001 && list.contains(i+1) && list.contains(i-1)) return true;
            else if(i == 1 && list.contains(i+1)) return true;
            else if(i == 10001 && list.contains(i-1)) return true;
        }
        return false;
    }
    private static void dfs(Node root){
        if(root == null) return;
        
        if(isLeaf(root)) leafs.add(root.data);
        else list.add(root.data);
        
        dfs(root.left);
        dfs(root.right);
    }
    public static boolean isLeaf(Node node){
        if(node == null) return false;
        return node.left == null && node.right == null;
    }
}
