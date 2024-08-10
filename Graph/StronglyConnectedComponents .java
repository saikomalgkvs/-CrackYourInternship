// Problem link:
// https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
import java.util.*;

class StronglyConnectedComponents{
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>(); // store nodes in order of first finished by DFS
        
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs1(i, adj, stack, vis);
            }
        }
        
        // Reverse the direction of all edges
        ArrayList<ArrayList<Integer>> adjListT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjListT.add(new ArrayList<>());
        }
        
        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                adjListT.get(j).add(i);
            }
        }
        
        int scc = 0;
        vis = new boolean[V];
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!vis[node]) {
                dfs2(node, adjListT, vis);
                scc++;
            }
        }
        return scc;
    }

    private void dfs1(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] vis) {
        vis[node] = true;
        
        for (int nextNode : adj.get(node)) {
            if (!vis[nextNode]) {
                dfs1(nextNode, adj, stack, vis);
            }
        }
        
        stack.push(node);
    }
    
    private void dfs2(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        
        for (int nextNode : adj.get(node)) {
            if (!vis[nextNode]) {
                dfs2(nextNode, adj, vis);
            }
        }
    }
}