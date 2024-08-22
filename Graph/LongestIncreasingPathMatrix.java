// Problem link: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/

public class LongestIncreasingPathMatrix {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        dp = new int[m + 1][n + 1];
        
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                max = Math.max(max, dfs(matrix, i, j, m, n, -1));
            }
        }
        return max;
    }
    private int dfs(int[][] matrix, int i, int j, int m, int n, int prevVal){
        if(i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] <= prevVal) return 0;        
        if(dp[i][j] != 0) return dp[i][j];

        int pathLen = 0;
        int curr = matrix[i][j];
        pathLen = Math.max(pathLen, dfs(matrix, i+1, j, m, n, curr));
        pathLen = Math.max(pathLen, dfs(matrix, i-1, j, m, n, curr));
        pathLen = Math.max(pathLen, dfs(matrix, i, j+1, m, n, curr));
        pathLen = Math.max(pathLen, dfs(matrix, i, j-1, m, n, curr));
        
        return dp[i][j] = ++pathLen;
    }
}