// Problem link: https://leetcode.com/problems/remove-boxes/description/

public class RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
            
        for(int i = 0; i < n; i++){
            for(int k = 0; k <= i; k++){
                dp[i][i][k] = (k + 1) * (k + 1);
            }
        }
            
        for(int p = 1; p < n; p++){
            for(int j = p; j < n; j++){
                int i = j - p;
                    
                for(int k = 0; k <= i; k++){
                    int ans = (k + 1) * (k + 1) + dp[i + 1][j][0];
                        
                    for(int m = i + 1; m <= j; m++){
                        if(boxes[m] == boxes[i]){
                            ans = Math.max(ans, dp[i + 1][m - 1][0] + dp[m][j][k + 1]);
                        }
                    }
                        
                    dp[i][j][k] = ans;
                }
            }
        }
        
        return (n == 0 ? n : dp[0][n - 1][0]);
    }
}
