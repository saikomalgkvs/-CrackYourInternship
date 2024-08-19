// Problem link: https://leetcode.com/problems/implement-trie-prefix-tree/description/

package Trie;

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
