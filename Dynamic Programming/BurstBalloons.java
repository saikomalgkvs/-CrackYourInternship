// Problem link: https://leetcode.com/problems/burst-balloons/

import java.util.Arrays;

public class BurstBalloons {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(nums, 0, n-1);
    }
    private int solve(int[] nums, int i, int j){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int max = 0;
        for(int k = i; k <= j; k++){

            int left = solve(nums,i,k-1);
            int right = solve(nums,k+1,j);
            int bk = i-1 < 0 ? 1 : nums[i-1]; // number before nums[k];
            int ak = j+1 >= nums.length ? 1 : nums[j+1]; // number after nums[k]

            int temp = left + right + bk * nums[k] * ak;
            max = Math.max(max, temp);
        }
        return dp[i][j] = max;
    }
}
