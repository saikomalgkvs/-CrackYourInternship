// Problem: Critical Connections in a Network
// Link: https://leetcode.com/problems/critical-connections-in-a-network/description/

import java.util.*;

public class CriticalConnections {
    List<List<Integer>> critical;
    int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        critical = new ArrayList<>();
        int[] exploreTime = new int[n];
        boolean[] vis = new boolean[n];
        
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(List<Integer> edge: connections){
            int a = edge.get(0); 
            int b = edge.get(1);

            adj[a].add(b);
            adj[b].add(a);
        }
        
        dfs(adj, 0, vis, exploreTime, -1);
        return critical;
    }
    
    private void dfs(List<Integer>[] adj, int v, boolean[] vis, int[] exploreTime, int prev){
        vis[v] = true;
        exploreTime[v] = time++;
        int current = exploreTime[v];
        
        for(int nextNode : adj[v]){
            if(nextNode == prev) continue;
            if(!vis[nextNode]) dfs(adj, nextNode, vis, exploreTime, v);

            exploreTime[v] = Math.min(exploreTime[v], exploreTime[nextNode]);
            if(current < exploreTime[nextNode]) critical.add(Arrays.asList(v, nextNode));
        }
    }
}
