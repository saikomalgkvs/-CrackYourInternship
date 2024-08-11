// Problem link: https://www.geeksforgeeks.org/problems/travelling-salesman-problem2732/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

public class TravellingSalesmanProblem {
    public int total_cost(int[][] cost)  {
        int n=cost.length;
        return getMinCost(cost, new int[1 << n][n], n, 0, 1);
    }
    private int getMinCost(int[][] cost, int[][] dp, int n, int curr, int mask) {  
        if(mask == (1 << n) - 1) return cost[curr][0];

        if(dp[mask][curr] == 0){
            dp[mask][curr] = Integer.MAX_VALUE;
            for(int i=0; i<n; i++){
                if((mask & (1 << i)) == 0){
                    int next = cost[curr][i]+getMinCost(cost, dp, n, i, mask | 1 << i);
                    dp[mask][curr] = Math.min(dp[mask][curr], next);
                }
            }
        }
        return dp[mask][curr];
    }    
}