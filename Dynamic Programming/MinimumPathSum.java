// Problem link:
// https://leetcode.com/problems/minimum-path-sum/description/

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];
        dp[0] = grid[0][0];

        for(int i=1; i<n; i++){
            dp[i] = dp[i-1] + grid[0][i];
        }
        // System.out.println(Arrays.toString(dp));

        for(int row = 1; row < m; row++){
            dp[0] += grid[row][0];
            for(int col = 1; col < n; col++){
                dp[col] = grid[row][col] + Math.min(dp[col-1], dp[col]);
            }
        }
        return dp[n-1];
    }
}
