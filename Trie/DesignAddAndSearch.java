// Problem: Design Add and Search Words Data Structure
// Link: https://leetcode.com/problems/design-add-and-search-words-data-structure/description/

package Trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode{
    Map<Character, TrieNode> children;
    boolean isWord;
    
    public TrieNode(){
        children = new HashMap<>();
        isWord = false;
    }
}

class DesignAddAndSearch {
    private TrieNode root;

    public DesignAddAndSearch() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!node.children.containsKey(c)) node.children.put(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(TrieNode node, String word, int index){
        if(index == word.length()) return node.isWord;
        char c = word.charAt(index);
        if(c == '.'){
            for(TrieNode child : node.children.values()){
                if(searchHelper(child, word, index + 1)) return true;
            }
            return false;
        }
        else{
            TrieNode child = node.children.get(c);
            if(child == null) return false;
            return searchHelper(child, word, index + 1);
        }
    }
}
