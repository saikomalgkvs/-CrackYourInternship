// Problem link:
// https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/

import java.util.Stack;

public class MinimumCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        
        for(int num : arr){
            while(stack.peek() <= num){
                int out = stack.pop();
                ans += (out * Math.min(stack.peek(), num));
            }
            stack.push(num);
        }

        while(stack.size() > 2){
            ans += stack.pop() * stack.peek();
        }

        return ans;
    }    
}
