// Problem link: https://www.geeksforgeeks.org/problems/alien-dictionary/1

import java.util.*;

public class AlienDictionary {
    public String findOrder(String[] dict, int n, int k) {

        List<List<Integer>> adj = new ArrayList<>(); // adjacency list
        for(int i = 0; i < k; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n - 1; i++){
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            
            // compare only first character
            for(int j = 0; j < len; j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        
        // topological sort
        int[] inDegree = new int[k];
        for(int i = 0; i < k; i++){
            for(int v : adj.get(i)){
                inDegree[v]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        char[] order = new char[k];
        int oi = 0; // index to fill order array
        
        for(int i = 0; i < k; i++){
            if(inDegree[i] == 0) q.offer(i);
        }
        
        while(!q.isEmpty()){
            int u = q.poll();
            order[oi++] = (char) (u + 'a');
            
            for(int v : adj.get(u)){
                inDegree[v]--;
                if(inDegree[v] == 0) q.offer(v);
            }
        }
        
        if(oi == k) return new String(order);
        return "";
    }    
}
