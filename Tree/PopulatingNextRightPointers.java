package Tree;
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class PopulatingNextRightPointers {
    public Node connect(Node root) {
        if(root == null) return root;

        if(root.left ==null && root.right ==null) return root; // for leaf node

        if(root.left !=null && root.right !=null) root.left.next = root.right; // connecting nodes of same parent
        
        if(root.next !=null) root.right.next = root.next.left; // connecting nodes of different parents

        connect(root.left);
        connect(root.right);

        return root;
    }
}
