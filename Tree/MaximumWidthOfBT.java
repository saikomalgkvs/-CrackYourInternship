// Maximum Width of Binary Tree
// Problem link:
// https://leetcode.com/problems/maximum-width-of-binary-tree/

package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumWidthOfBT {
    class Pair {
        TreeNode node;
        int value;

        Pair(TreeNode node, int value){
            this.node = node;
            this.value = value;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair > dq = new ArrayDeque<>();
        int ans = 0;

        if(root == null) return ans;

        dq.add(new Pair(root,1));

        while(!dq.isEmpty()){
            int max = dq.getLast().value - dq.getFirst().value + 1;
            ans = Math.max(ans,max);
            int size = dq.size();

            for(int i=0; i<size ;i++){
                Pair  out = dq.pop();
                TreeNode temp  = out.node;
                int val = out.value;

                if(temp.left != null) dq.add(new Pair(temp.left, val*2));

                if(temp.right != null) dq.add(new Pair(temp.right, val*2+1));
            }
       }
       return ans;
    }
}
