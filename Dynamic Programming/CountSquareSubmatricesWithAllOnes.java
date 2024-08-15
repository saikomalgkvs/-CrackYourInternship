// Problem link: https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/

public class CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int count = 0;
        int[][] dp = new int[rows][cols];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) continue;
                dp[i][j] = matrix[i][j] + Math.min(getValue(i+1, j, dp),
                        Math.min(getValue(i,j+1, dp), getValue(i+1,j+1, dp)));
                count += dp[i][j];
            }
        }
        return count;
    }

    private int getValue(int i, int j, int[][] matrix) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return 0;
        return matrix[i][j];
    }
}
