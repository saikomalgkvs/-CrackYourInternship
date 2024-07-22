package Trees;

public class ConstructTreeFromPreorderTraversal {
    class Node{
        int data;
        Node left,right;
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }
    int index = 0;
    Node constructTree(int n, int pre[], char preLN[]) {
        if (index >= n) return null;

        Node newNode = new Node(pre[index++]);

        if(preLN[index - 1] == 'N'){
            newNode.left = constructTree(n, pre, preLN);
            newNode.right = constructTree(n, pre, preLN);
        }

        return newNode;
    }
}
