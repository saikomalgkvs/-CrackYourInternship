package Tree;
class Node  { 
    int data; 
    Node left, right; 
   
    public Node(int d)  { 
        data = d; 
        left = right = null; 
    } 
}
class Info {
    int minVal; // Minimum value in the subtree
    int maxVal; // Maximum value in the subtree
    int size;   // Size of the subtree if it is a BST

    Info(int mi, int ma, int s) {
        minVal = mi;
        maxVal = ma;
        size = s;
    }
}
public class LargestBST {
    static final int MAX = Integer.MAX_VALUE;
    static final int MIN = Integer.MIN_VALUE;
    
    static int largestBst(Node root) {
        return solve(root).size;
    }

    static Info solve(Node root) {
        if (root == null) return new Info(MAX, MIN, 0);
        
        Info left = solve(root.left);
        Info right = solve(root.right);
        
        if (left.maxVal < root.data && root.data < right.minVal) {
            return new Info(Math.min(root.data, left.minVal), Math.max(root.data, right.maxVal), left.size + right.size + 1);
        }
        
        return new Info(MIN, MAX, Math.max(left.size, right.size));
    }
}
