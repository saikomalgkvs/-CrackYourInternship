package Arrays;

// Problem Link
// https://leetcode.com/problems/max-value-of-equation/description/

import java.util.Deque;
import java.util.LinkedList;

public class MaxValueOfEquation {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int n = points.length;
        
        Deque<Integer> q = new LinkedList<>();

        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            
            while(!q.isEmpty() && points[i][0] - points[q.peek()][0] > k) q.poll();

            if(!q.isEmpty()) ans = Math.max(ans, points[i][0] + points[i][1] + points[q.peek()][1] - points[q.peek()][0]);

            while (!q.isEmpty() && points[q.peekLast()][1] - points[q.peekLast()][0] < points[i][1] - points[i][0])
                q.pollLast();

            q.add(i);
        }
        return ans;

        // BRUTE FORCE
        // int max = Integer.MIN_VALUE;
        // for(int i=0; i<points.length-1; i++){
        //     for(int j=i+1; j<points.length; j++){
        //         int mod = Math.abs(points[i][0]-points[j][0]);
        //         if (mod <= k){
        //             int eq = points[i][1] + points[j][1] + mod;
        //             if(eq>max) max = eq;
        //         }
        //     }        
        // }
        // return max;
    }
}
