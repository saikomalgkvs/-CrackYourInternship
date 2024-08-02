// Problem link:
// https://www.geeksforgeeks.org/problems/maximum-of-minimum-for-every-window-size3453/1

import java.util.Stack;

public class MaximumOfMinimumForEveryWindowSize {
    static int[] maxOfMin(int[] arr, int n){
        int min = arr[0];
        
        Stack<Integer> stack = new Stack<Integer>();
        
        int[] left = new int[n];
        
        for(int i=0; i<n; i++)
        {
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();   
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
            
            min = Math.min(min, arr[i]);
        }
        
        stack = new Stack<Integer>();
        
        int[] right = new int[n];
        
        for(int i=n-1; i>=0; i--)
        {
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();   
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
            
        }
        
        int[] result = new int[n];
        
        for(int i=0; i<n; i++)
        {
            int size = right[i] - left[i] - 1;
            if(result[size-1] < arr[i]) result[size-1] = arr[i];
        }
        
        for(int i=n-1; i>=0; i--){
            if(result[i] < min) result[i] = min;
            else min = result[i];
        }
        
        return result;
    }
}
