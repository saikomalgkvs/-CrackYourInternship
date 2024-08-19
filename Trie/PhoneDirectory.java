// Problem link: https://www.geeksforgeeks.org/problems/phone-directory4628/1

package Trie;

import java.util.ArrayList;

class Trie {
    class Node{
        Node[] children;
        boolean isEnd;
        String word;

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
        temp.word = word;
    }
    
    public boolean search(String word) {
        Node temp = root;
        for(char c : word.toCharArray()){
            if(!temp.containsKey(c)) return false;
            temp = temp.get(c);
        }
        return temp.isEnd;
    }
    
    public ArrayList<String> startsWith(String prefix) {
        
        ArrayList<String> result = new ArrayList<>();
        
        Node temp = root;
        for(char c : prefix.toCharArray()){
            if(!temp.containsKey(c)) return result; // no string found, returns empty list
            temp = temp.get(c);
        }
        
        // from temp do dfs and add temp.word where isEnd == true
        dfs(temp, result);
        return result;
    }
    public void dfs(Node temp, ArrayList<String> result){
        
        if(temp == null) return;
        if(temp.isEnd) result.add(temp.word);
        
        for(char c ='a'; c <= 'z'; c++){
            if(temp.containsKey(c)) dfs(temp.get(c), result);
        }
    }
}
class PhoneDirectory{
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s){
        Trie trie = new Trie();
        for(String str : contact){
            trie.insert(str);
        }
        
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        // list.addAll(trie.startsWith(s.substring(0,1)));
        // result.add(list);
        for(int i=1; i<=s.length(); i++){
            
            list.addAll(trie.startsWith(s.substring(0,i)));
            
            if(list.size() == 0){
                list.add("0");
            }
            result.add(list);
            list = new ArrayList<>();
        }
        return result;
    }
}
