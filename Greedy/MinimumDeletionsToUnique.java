// Problem: Minimum Deletions to Make Character Frequencies Unique
// Link: https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/description/

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionsToUnique {
    public int minDeletions(String s) {
        int[] count = new int[26];

        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }

        Set<Integer> set = new HashSet<>();
        int deleted = 0;
        for(int i : count){
            int del = 0;
            while(i !=0 && set.contains(i)){
                i -= 1;
                del++;
            }
            deleted += del;
            if(i!=0) set.add(i);
        }
        return deleted;
    }
}