package Trees;

public class PreorderToBST {
    class Node {
        int data;
        Node left, right;
    
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    // Function that constructs BST from its preorder traversal.
    public Node Bst(int pre[], int size) {
        Node head = new Node(pre[0]);
        
        for(int i=1; i<size; i++){
            head = insert(head, pre[i]);
        }
        return head;
    }
    private Node insert(Node node, int data){
        if(node == null) return new Node(data);
        
        if(data < node.data) node.left = insert(node.left, data);
        if(data > node.data) node.right = insert(node.right, data);
        
        return node;
    }
}
