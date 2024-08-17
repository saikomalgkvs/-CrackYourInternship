// Problem link: https://www.geeksforgeeks.org/problems/optimal-binary-search-tree2214/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

public class OptimalBST{
    public static int optimalSearchTree(int keys[], int freq[], int n){
        
        int dp[][] = new int[n + 1][n + 1];
 
        for(int i = 0; i < n; i++){
            dp[i][i] = freq[i];
        }
 
        for(int L = 2; L <= n; L++){
            for(int i = 0; i <= n - L + 1; i++){
                
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                int offSetSum = sum(freq, i, j);
                
                for(int r = i; r <= j; r++){
                    int c = ((r > i) ? dp[i][r - 1] : 0) + ((r < j) ? dp[r + 1][j] : 0) + offSetSum;
                    if (c < dp[i][j]) dp[i][j] = c;
                }
            }
        }
        return dp[0][n - 1];
    }
 
    private static int sum(int freq[], int i, int j){
        int ans = 0;
        for(int idx = i; idx <= j; idx++) {
            if (idx >= freq.length) continue;
            ans += freq[idx];
        }
        return ans;
    }
}
