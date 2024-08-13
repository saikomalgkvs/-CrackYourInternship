// Problem link: https://leetcode.com/problems/minimum-window-substring/description/

package Strings;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] freq = new int[123];

        for(int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]++;
        }

        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int copy;
        int len;

        for(int i = 0, e = 0, count = t.length(); e < s.length(); e++) {
            if (freq[s.charAt(e)]-- > 0) count--;
            
            copy = count;
            while(count == 0 && i <= e) {
                if(freq[s.charAt(i++)]++ >= 0) count++;
            }

            if(copy == 0 && minLen > (len = e - i + 2)){
                minLen = len;
                start = i - 1;
            }
        }
        return minLen != Integer.MAX_VALUE ? s.substring(start, start + minLen) : "";
    }
}
