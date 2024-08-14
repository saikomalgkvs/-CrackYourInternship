package Strings;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        int[][] dp = new int[lt + 1][ls + 1];

        for(int j=0; j <= s.length(); j++){
            dp[0][j] = 1;
        }
                
        for(int i=0; i < lt; i++){
            for(int j=0; j < ls; j++){
                if(t.charAt(i) == s.charAt(j)) dp[i+1][j+1] = dp[i][j] + dp[i+1][j];
                else dp[i+1][j+1] = dp[i+1][j];
            }
        }
        return dp[lt][ls];
    }
}
