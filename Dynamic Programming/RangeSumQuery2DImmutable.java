// Problem link: https://leetcode.com/problems/range-sum-query-2d-immutable/description/

public class RangeSumQuery2DImmutable {
    int[][] dp;
    public RangeSumQuery2DImmutable(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        fillDP(matrix);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0) return dp[row2][col2];
        else if(row1 == 0) return dp[row2][col2] - dp[row2][col1-1];
        else if(col1 == 0) return dp[row2][col2] - dp[row1-1][col2];
        return dp[row2][col2] - dp[row2][col1-1] - dp[row1-1][col2] + dp[row1-1][col1-1];
    }

    private void fillDP(int[][] matrix){
        dp[0][0] = matrix[0][0];
        for(int j=1; j<matrix[0].length; j++){ // fill first row
            dp[0][j] = dp[0][j-1] + matrix[0][j];
        }

        for(int i=1; i<matrix.length; i++){ // fill first column
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }

        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                dp[i][j] = matrix[i][j] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1];
            }
        }
    }
}