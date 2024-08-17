// Problem link: https://leetcode.com/problems/maximal-square/description/

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        char[][] dp = new char[m][n];
                      
        char max = '0';
        for(int i=0; i<m; i++){ // fill first column
            dp[i][0] = matrix[i][0];
            max = max > dp[i][0] ? max : dp[i][0];
            
        }

        for(int j=0; j<n; j++){ // fill first row
            dp[0][j] = matrix[0][j];
            max = max > dp[0][j] ? max : dp[0][j];
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                char l = dp[i-1][j];
                char u = dp[i][j-1];
                char d = dp[i-1][j-1];

                char min = u < l ? u : l;
                min = min < d ? min : d;

                if(l != '0' && u != '0' && d != '0' && matrix[i][j] == '1'){
                    dp[i][j] = (char) (min + 1);
                    max = max > dp[i][j] ? max : dp[i][j];
                }
                else{ 
                    dp[i][j] = matrix[i][j];
                    max = max > dp[i][j] ? max : dp[i][j];
                }
            }
        }
        return (max - '0') * (max - '0');
    }
}