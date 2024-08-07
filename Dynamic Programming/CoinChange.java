// Problem link:
// https://leetcode.com/problems/coin-change/description/


import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0] = 0;

        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0){
                    if(minCoins[i - coins[j]] == Integer.MAX_VALUE) continue;
                    else minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coins[j]]);
                }
            }
        }
        System.out.println(minCoins[0]);
        return minCoins[amount] != Integer.MAX_VALUE ? minCoins[amount] : -1;        
    }
}
