// Find All Possible Palindromic Partitions of a String
// Problem link:
// https://www.geeksforgeeks.org/problems/find-all-possible-palindromic-partitions-of-a-string/1

package Backtracking;

import java.util.ArrayList;
import java.util.Stack;

public class FindAllPossiblePalindromicPartitions {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String s) {
        int n = s.length();

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Stack<String> partitions = new Stack<>();

        backtrack(result, partitions, s, n, 0);
        return result;     
    }
    private static void backtrack(ArrayList<ArrayList<String>> result, Stack<String> partitions, String s, int n, int start){
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
    private static boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }    
}
