// Problem link: https://leetcode.com/problems/word-ladder/description/

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> map = new HashMap<>(); 

        for(int i = 0; i < beginWord.length(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(beginWord.substring(0,i));
            sb.append('*');
            sb.append(beginWord.substring(i+1));

            String str = sb.toString();
            map.computeIfAbsent(str, k -> new ArrayList<>()).add(beginWord);
        }
        
        for(String word: wordList){
            for(int i = 0; i < word.length(); i++){
                StringBuilder sb = new StringBuilder();
                sb.append(word.substring(0,i));
                sb.append('*');
                sb.append(word.substring(i+1));

                String str = sb.toString();
                map.computeIfAbsent(str, k -> new ArrayList<>()).add(word);
            }
        }
        // performing BFS;
        // to find shortest path, bfs is used. Once word sk is found shortest length is found
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        int length = 0;
        Set<String> vis = new HashSet<>();

        while(!queue.isEmpty()){
            length++;
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                String out = queue.poll();
                if(out.equals(endWord)) return length;

                for(int j = 0; j < out.length(); j++){
                    StringBuilder sb = new StringBuilder();
                    sb.append(out.substring(0,j));
                    sb.append('*');
                    sb.append(out.substring(j+1));

                    String str = sb.toString();
                    if(map.containsKey(str)){
                        for(String s : map.get(str)){
                            if(!vis.contains(s)){
                                vis.add(s);
                                queue.offer(s);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}
