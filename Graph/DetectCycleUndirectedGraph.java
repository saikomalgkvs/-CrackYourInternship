import java.util.ArrayList;

// Detect cycle in an undirected graph
public class DetectCycleUndirectedGraph {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(!vis[i] && dfs(adj, i, vis, -1)) return true;
        }
        return false;
    }
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] vis, int p){
        vis[curr] = true;
        
        for(int i=0; i<adj.get(curr).size(); i++){
            int node = adj.get(curr).get(i);
            if(!vis[node]){
                if(dfs(adj, node, vis, curr)) return true;
            }
            else if(vis[node] && node != p) return true;
        }
        return false;
    }
}