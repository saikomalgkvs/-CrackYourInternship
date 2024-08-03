// Min distance between two given nodes of a Binary Tree
// Problem link:
// https://www.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1

package Tree;

public class MinDistanceGivenTwoNodesBT {
    int findDist(Node root, int a, int b) {
        Node lca = getLCA(root, a, b);
        // return (lca.data);
        
        return dfs(lca, a, 0) + dfs(lca, b, 0);
    }
    
    private int dfs(Node node, int a, int d){
        if(node == null) return -1;
        if(node.data == a) return d;
        
        int left = dfs(node.left, a, d+1);
        if(left == -1) return dfs(node.right, a, d+1);
        else return left;
    }
    private Node getLCA(Node root, int a, int b){
        if(root == null) return null;
        
        if(root.data == a || root.data == b) return root;
        
        Node left = getLCA(root.left, a, b);
        Node right = getLCA(root.right, a, b);
        
        if(left == null) return right;
        if(right == null) return left;
        
        if(left!= null && right!=null) return root;
        return null;
        
        
    }    
}
