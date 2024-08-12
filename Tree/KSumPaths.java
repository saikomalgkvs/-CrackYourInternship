// Problem link: https://www.geeksforgeeks.org/problems/k-sum-paths/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

package Tree;

import java.util.Stack;

public class KSumPaths {
    int count = 0;
    public int sumK(Node root,int k){
        if(root == null) return 0;
        Stack<Integer> stack = new Stack<Integer>();
         
        pathSum(root, k, stack);
        return count;
    }
    
    public void pathSum(Node root, int k, Stack<Integer> stack){
        if(root == null) return;
        stack.add(root.data);
        
        int total = 0;
        for(int i = stack.size() - 1; i >= 0 ; i--){
            total += stack.get(i);
            if(total == k) count++;
        }
        
        pathSum(root.left, k , stack);
        pathSum(root.right, k, stack);
        
        stack.pop();
    }
}
