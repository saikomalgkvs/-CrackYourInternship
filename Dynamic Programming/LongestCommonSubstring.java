// Problem link: https://www.geeksforgeeks.org/problems/longest-common-substring1452/1

public class LongestCommonSubstring {
    public int longestCommonSubstr(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        
        int[][] dp = new int[l1+1][l2+1];
        int maxLength = 0;
        
        for(int i=1; i<=l1; i++){
            for(int j=1; j<=l2; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        
        return maxLength;
    }
}
