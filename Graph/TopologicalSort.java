// Problem link: https://www.geeksforgeeks.org/problems/topological-sort/1

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<V; i++){
            if(!vis[i]) dfs(i, adj, stack, vis);
        }
        
        int[] sorted = new int[V];
        for(int i=0; i<V; i++){
            sorted[i] = stack.pop();
        }
        
        return sorted;
    }
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> s, boolean[] vis){
        if(vis[node]) return;
        
        vis[node] = true;
        
        for(int nextNode : adj.get(node)){
            dfs(nextNode, adj, s, vis);
        }
        
        s.push(node);
    }  
}