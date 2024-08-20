// Problem link https://leetcode.com/problems/maximal-rectangle/description/

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int[] dp = new int[n + 1];
        int area = 0;

        for(char[] row : matrix){
            for(int i = 0; i < n; i++){
                if(row[i] == '1') dp[i] = dp[i] + 1;
                else dp[i] = 0;
            }

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i <= n; i++) {
                while (!stack.isEmpty() && dp[i] < dp[stack.peek()]) {
                    int h = dp[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    area = Math.max(area, h * w);
                }
                stack.push(i);
            }
        }

        return area;
    }
}
