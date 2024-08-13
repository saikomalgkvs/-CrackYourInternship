// Problem link: https://www.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1

package Strings;

public class SmallestWindowInAString {
    public static String smallestWindow(String s, String p)
    {
        int n = s.length();
        int[][] preSum = new int[n][26];
        preSum[0][s.charAt(0) - 'a']++;
        for(int i = 1 ; i < n ; i++){
            preSum[i][s.charAt(i) - 'a']++;
            for(int j = 0 ; j < 26 ; j++){
                preSum[i][j] += preSum[i - 1][j];
            }
        }

        int[] pFreq = new int[26];
        for(char c : p.toCharArray()){
            pFreq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() + 1; i++)sb.append("1");
        String temp = sb.toString();

        boolean flag = false;
        int i = 0 , j = 1;
        while(j < n){
            while(i < n && calculateFreq(s,preSum,pFreq,i,j)){
                i++;
                flag = true;
            }
            if(flag){
                if(sb.length() - 1 > (j - i + 1)){
                    sb = new StringBuilder();
                    sb.append(s.substring(i - 1,j + 1));
                }

                flag = false;
            }
            j++;
        }
        return sb.toString().equals(temp)?"-1":sb.toString();
    }
    public static boolean calculateFreq(String s ,int[][] preSum , int[] pFreq , int i , int j ){
        for(int k = 0 ; k < 26; k++){
            int freq = preSum[j][k] - ((i > 0)? preSum[i - 1][k] : 0);
            if(pFreq[k] > freq)return false;
        }
        return true;
    }
}