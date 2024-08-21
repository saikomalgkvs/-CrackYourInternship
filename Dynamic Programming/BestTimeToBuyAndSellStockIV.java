// Problem link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int [][][]dp = new int [n][2][k+1];
        for(int [][]i:dp){
            for(int []j:i){
                Arrays.fill(j,-1);
            }
        }
        return solve(0,n,0,k,prices,dp);
    }
    private int solve(int i, int n, int buy, int k, int[] prices, int[][][] dp){
        if(i == n || k==0) return 0;
        if(dp[i][buy][k]!=-1) return dp[i][buy][k];

        int profit = 0;
        int a = solve(i+1,n,0,k,prices,dp);
        int b = prices[i];
        int c = solve(i+1,n,1,k,prices,dp);
        
        if(buy == 0){
            profit = Math.max(a, c - b);
        }
        if(buy == 1){
            profit = Math.max(c, b + solve(i+1,n,0,k-1,prices,dp));
        }
        return dp[i][buy][k] = profit;
    }
}