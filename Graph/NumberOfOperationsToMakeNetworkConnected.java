// Problem link:https:
// leetcode.com/problems/number-of-operations-to-make-network-connected/description/

import java.util.ArrayList;

class NumberOfOperationsToMakeNetworkConnected{
    public int makeConnected(int n, int[][] connections) {
        if(n-1 > connections.length) return -1;
        
        ArrayList<Integer>[] list = new ArrayList[n];

        for(int i=0; i<n; i++){
            list[i] = new ArrayList<Integer>();
        }
        
        for(int[] edge : connections){
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }

        int islands = 0;
        boolean[] vis = new boolean[n];
        for(int node = 0; node<n; node++){
            if(!vis[node]){
                dfs(node, list, vis);
                islands++;
            }
        }
        
        return islands-1;
    }
    private void dfs(int node, ArrayList<Integer>[] list, boolean[] vis){
        if(vis[node]) return;
        vis[node] = true;

        for(int n : list[node]){
            dfs(n, list, vis);
        }
    }
}