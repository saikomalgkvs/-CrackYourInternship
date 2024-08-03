package Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeToDLL {
    List<Node> inorder;
    
    Node bToDLL(Node root){
	    inorder = new ArrayList<Node>();
	    dfs(root);
	    
	    for(int i=0; i<inorder.size()-1; i++){
	        Node a = inorder.get(i);
	        Node b = inorder.get(i+1);
	        a.right = b;
	        b.left = a;
	    }
        return inorder.get(0);

    }
    private void dfs(Node node){
        if(node == null) return;
	    dfs(node.left);
	    inorder.add(node);
	    dfs(node.right);
    }
}
