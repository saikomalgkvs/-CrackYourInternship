package Heaps;

import java.util.Iterator;
import java.util.Stack;

class FindTheMostCompetitiveSubsequence{
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();

        int n = nums.length;
        for(int i=0; i<n; i++){
            if(stack.isEmpty()) stack.push(nums[i]);
            else{
                while(!stack.isEmpty() && stack.peek() > nums[i]  && i-stack.size() < n-k) stack.pop();
                stack.push(nums[i]);
            }
        }
        
        int[] arr = new int[k];
        Iterator<Integer> itr = stack.iterator();

        int i=0;
        while(itr.hasNext() && i<k){
            arr[i++] = (int) itr.next();
        }
        return arr;
    }
}