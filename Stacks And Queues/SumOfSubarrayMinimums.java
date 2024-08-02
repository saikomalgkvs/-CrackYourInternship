// Problem link:
// https://leetcode.com/problems/sum-of-subarray-minimums/

import java.util.Arrays;
import java.util.Stack;

class SumOfSubarrayMinimums{
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        Arrays.fill(left, -1);
        int[] right = new int[n];
        Arrays.fill(right, n);


        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()) left[i] = stack.peek();
            stack.push(i);
        }

        stack.clear();

        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()) right[i] = stack.peek();
            stack.push(i);
        }

        final int mod = (int) 1e9 +7;
        long sum = 0;
        for(int i=0; i<n; i++){
            sum += (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
            sum %= mod;
        }
        return (int) (sum);
    }
}