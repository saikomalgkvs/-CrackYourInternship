// Problem link:
// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/

import java.util.Stack;

public class MinimumTimeToMakeRopeColorful {
    public int minCost(String colors, int[] neededTime) {
        char[] arr = colors.toCharArray();
        Stack<Integer> stack = new Stack<>();

        int n = arr.length;
        int totalTime = 0;
        boolean shouldAdd;
        for(int i=0; i<n; i++){
            shouldAdd = true;
            if(!stack.isEmpty() && arr[stack.peek()] == arr[i]){
                if(neededTime[stack.peek()] < neededTime[i]){
                    totalTime += neededTime[stack.pop()];
                }
                else{
                    shouldAdd = false;
                    totalTime += neededTime[i];
                }
            }
            if(shouldAdd) stack.push(i);
        }
        System.out.println(stack);
        return totalTime;
    }
}
