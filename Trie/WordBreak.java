// Problem link: https://www.geeksforgeeks.org/problems/word-break-trie--141631/1
package Trie;

import java.util.ArrayList;
class Trie {
    class Node{
        Node[] children;
        boolean isEnd;

        Node(){
            children = new Node[26];
            isEnd = false;
        }
        boolean containsKey(char c){
            return children[c - 'a'] != null;
        }
        void put(char c, Node node){
            children[c - 'a'] = node;
        }
        Node get(char c){
            return children[c - 'a'];
        }
    }
    private Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        for(char c : word.toCharArray()){
            if(!temp.containsKey(c)){
                temp.put(c, new Node());
            }
            temp = temp.get(c);
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        Node temp = root;
        for(char c : word.toCharArray()){
            if(!temp.containsKey(c)) return false;
            temp = temp.get(c);
        }
        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;
        for(char c : prefix.toCharArray()){
            if(!temp.containsKey(c)) return false;
            temp = temp.get(c);
        }
        return true;
    }
}
public class WordBreak
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        Trie trie = new Trie();
        for(String b : B){
            trie.insert(b);
        }
        
        if(helper(trie, A)) return 1;
        return 0;
    }
    static boolean helper(Trie trie, String str){
        
        if(str.length() == 0) return true;
        
        for(int i=1; i<=str.length(); i++){
            if(trie.search(str.substring(0,i)) && helper(trie, str.substring(i))) return true;
        }
        return false;
    }
}