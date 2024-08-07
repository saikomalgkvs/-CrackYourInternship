import java.util.Arrays;

public class KnightDialer {
    int[][] moves = {{4, 6},{6, 8},{7, 9},{4, 8},{3, 9, 0},{},{1, 7, 0},{2, 6},{1, 3},{2, 4}};
    int[][] dp;
    int mod = 1000000007;
    
    public int knightDialer(int n){
        dp = new int[n+1][10];
        Arrays.fill(dp[1],1);

        for(int len = 2; len <= n; len++){
            for(int num = 0; num < 10; num++){
                for(int nextNum : moves[num]){
                    dp[len][num] = (dp[len][num] + dp[len-1][nextNum]) % mod;
                }
            }
        }

        int dials = 0;
        for(int count : dp[n]){
            dials = (dials + count) % mod;
        }
        return dials;
    }
}
