// Problem link:
// https://leetcode.com/problems/palindrome-partitioning/description/

package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        int n = s.length();

        List<List<String>> result = new ArrayList<>();
        Stack<String> partitions = new Stack<>();

        backtrack(result, partitions, s, n, 0);
        return result;     
    }
    private void backtrack(List<List<String>> result, Stack<String> partitions, String s, int n, int start){
        if(start == n){
            result.add(new ArrayList<>(partitions));
            return;
        }

        for(int end = start+1; end <= n; end++){
            if(isPalindrome(s, start, end-1)){
                partitions.push(s.substring(start, end));
                backtrack(result, partitions, s, n, end);
                partitions.pop();
            }
        }
    }
    private boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
