// Problem link: https://leetcode.com/problems/binary-tree-cameras/description/

package Tree;

public class BinaryTreeCameras {
    int cameras = 0;
    public int minCameraCover(TreeNode root) {
        cameras = 0;
        int ans = helper(root);
        return (ans == 0) ? ++cameras : cameras;
    }

    private int helper(TreeNode node){
        if(node == null) return 1;

        int left = helper(node.left);
        int right = helper(node.right);

        if(left == 0 || right == 0){
            cameras++;
            return 2;
        }

        if(left == 1 && right == 1) return 0;
        if(left == 2 || right == 2) return 1;

        return -1;
    }
}
