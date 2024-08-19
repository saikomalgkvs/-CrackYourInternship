// Problem link: https://leetcode.com/problems/palindrome-pairs/submissions/1361444024/

package Trie;
import java.util.*;

class TrieNode {
    TrieNode[] children;
    int index;
    List<Integer> list;
    	
    TrieNode() {
    	children = new TrieNode[26];
    	index = -1;
    	list = new ArrayList<>();
    }
}
class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        TrieNode root = new TrieNode();
            
        for (int i = 0; i < words.length; i++) {
            insert(root, words[i], i);
        }
            
        for (int i = 0; i < words.length; i++) {
            search(words, i, root, result);
        }
        
        return result;
    }
    private void insert(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';
                    
            if (root.children[j] == null) root.children[j] = new TrieNode();
            if (isPalindrome(word, 0, i)) root.list.add(index);
                    
            root = root.children[j];
        }
            
        root.list.add(index);
        root.index = index;
    }
    
    private void search(String[] words, int i, TrieNode root, List<List<Integer>> result) {
        for (int j = 0; j < words[i].length(); j++) {	
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                result.add(Arrays.asList(i, root.index));
            }
                
            root = root.children[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }
            
        for (int j : root.list) {
            if (i == j) continue;
            result.add(Arrays.asList(i, j));
        }
    }
        
    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }
}
