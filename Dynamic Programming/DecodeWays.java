// Problem link: https://leetcode.com/problems/decode-ways/

class DecodeWays{
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;

        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        char curr;
        char prev;
        for(int i=2; i<=n; i++){
            curr = s.charAt(i-1);
            prev = s.charAt(i-2);

            if(curr != '0') dp[i] += dp[i-1];
            if(prev == '1' || (prev == '2' && curr <= '6')) dp[i] += dp[i-2];
        }
        
        return dp[n];
    }
}