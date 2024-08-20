// Problem link: https://leetcode.com/problems/frog-jump/description/

import java.util.HashMap;
import java.util.Map;

public class FrogJump {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(stones[i], i);
        }
        
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true; 
       
        for(int i = 0; i < n; i++){
            for(int j = i-1; j >= 0; j--){
                int d = stones[i] - stones[j];
                if(d > j+1) break;  
                if(dp[j][d-1] || dp[j][d] || dp[j][d+1]){
                    dp[i][d] = true;
                    if (i == n-1) return true;  
                }
            }
        }
        return false;
    }
}
