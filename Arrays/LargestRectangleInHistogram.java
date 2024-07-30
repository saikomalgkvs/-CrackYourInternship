package Arrays;

import java.util.Stack;

// Problem link:
// https://leetcode.com/problems/largest-rectangle-in-histogram/description/
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int n = heights.length;
        int[] left  = new int[n];
        int[] right  = new int[n];

        for(int i=0; i<n; i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
            if(s.isEmpty()) left[i] = -1;
            else left[i] = s.peek();
            s.push(i);
        }
        s.clear();

        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
            if(s.isEmpty()) right[i] = n;
            else right[i] = s.peek();
            s.push(i);
        }

        int area = 0;
        for(int i=0; i<n; i++){
            area = Math.max(area, (right[i]-left[i]-1)*heights[i]);
        }

        return area;
    }
}
