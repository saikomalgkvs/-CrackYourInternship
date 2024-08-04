// Problem link:
// https://leetcode.com/problems/longest-repeating-character-replacement/

class LongestRepeatingCharacterReplacement{
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int n = s.length();

        for(char c = 'A'; c <= 'Z'; c++){
            int i = 0;
            int j = 0;
            int replaced = 0;
            while(j<n){
                if(s.charAt(j) == c) j++;
                else if (replaced < k){
                    j++;
                    replaced++;
                }
                else if(s.charAt(i) == c) i++;
                else{
                    i++;
                    replaced--;
                }
                ans = Math.max(ans, j-i);
            }
        }
        return ans;
    }
}