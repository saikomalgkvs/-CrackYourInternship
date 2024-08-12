package Tree;

import java.util.Stack;

public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<Integer> list = new Stack<>();
        inorder(root, k, list);
        return list.peek();
    }
    private void inorder(TreeNode node, int k, Stack<Integer> list){
        if(node == null || list.size() == k) return;

        inorder(node.left, k, list);
        if(list.size() == k) return;
        list.push(node.val);
        inorder(node.right, k, list);
    }
}
