package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
     public static boolean isAnagram(String s, String t){
        char[] a = s.toCharArray();
        Arrays.sort(a);
        char[] b = t.toCharArray();
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> ans = new HashMap<>();

        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);

            if(!ans.containsKey(key)){
                ans.put(key,new ArrayList<>());
            }
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());

        // BRUTE FORCE List<List<String>> ans = new ArrayList<>();
        // boolean[] added = new boolean[strs.length];
        // for(int i=0; i<strs.length; i++){
        //     List<String> anagrams = new ArrayList<>();
        //     if(!added[i]){
        //         for(int j = i+1; j<strs.length; j++){
        //             if(!added[j] && isAnagram(strs[i],strs[j])){
        //                 anagrams.add(strs[j]);
        //                 added[j] = true;
        //             }
        //         }
        //         anagrams.add(strs[i]);
        //         added[i] = true;
        //     }
        //     if(!anagrams.isEmpty()) ans.add(anagrams);
        // }
        // return ans;
    }
}
