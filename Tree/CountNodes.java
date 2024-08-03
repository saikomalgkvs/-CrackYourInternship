package Trees;

/* Count BST nodes that lie in a given range */
public class CountNodes {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    int count = 0;
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int h)
    {
        if(root == null) return 0;
        if(root.data >=l && root.data <= h) count++;
        
        getCount(root.left, l, h);
        getCount(root.right, l, h);
        
        return count;
    }
}
