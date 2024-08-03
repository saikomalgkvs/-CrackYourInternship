package Trees;
import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<String> paths;

    Solution(){
        paths = new ArrayList<>();
    }
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);

        return paths;
    }
    public void helper(TreeNode node, StringBuilder sb){
        int len = sb.length();
        if(node.left ==null & node.right ==null){
            sb.append(node.val);
            paths.add(sb.toString());
            sb.setLength(len);
            return;
        }
        sb.append(node.val + "->");

        if(node.left!=null) helper(node.left, sb);
        if(node.right!=null) helper(node.right,sb);

        sb.setLength(len);
    }
}
