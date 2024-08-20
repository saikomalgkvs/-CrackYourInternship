// Problem link: https://leetcode.com/problems/minimum-cost-to-merge-stones/description/

public class MinCostToMergeStones {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        int[][] dp = new int[n + 1][n + 1];
        int[] prefixSum = new int[n + 1];
        
        if((n-1) % (k-1) != 0) return -1;

        for(int index=0; index<n; index++){
            prefixSum[index+1] = prefixSum[index] + stones[index];
        }
        
        for(int p = k; p <= n; p++){ 
            for(int i = 0; i <= n - p; i++){ 
                int j = i + p -1; 
                dp[i][j] = Integer.MAX_VALUE;
                for(int m = i; m < j; m += k - 1){
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }
                if ((j-i) % (k-1) == 0) {
                    dp[i][j] += prefixSum[j + 1] - prefixSum[i];
                }
            }
        }
        return dp[0][n - 1];
    }
}
