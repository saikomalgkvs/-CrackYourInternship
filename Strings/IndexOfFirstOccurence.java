package Stacks;

class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        for(int i=0; i<haystack.length()-n+1; i++){
            if(haystack.substring(i,i+n).equals(needle)) return i;
        }
        if(haystack.equals(needle)) return 0;
        return -1;
    }
}
