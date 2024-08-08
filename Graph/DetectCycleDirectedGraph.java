import java.util.ArrayList;

class DetectDycleDirectedGraph{
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] vis2 = new boolean[V];
        boolean[] vis = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i] && dfs(adj, i, vis, vis2, V)) return true;
        }
        return false;
    }
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] vis, boolean[] vis2, int V){
        vis[curr] = true;
        vis2[curr] = true;

        for(int i=0; i<adj.get(curr).size(); i++){
            int node = adj.get(curr).get(i);
            
            if(vis2[node]) return true;
            if(vis[node]) continue;
            else{
                if(dfs(adj, node, vis, vis2, V)) return true;
            }
        }
        vis2[curr] = false;
        return false;
    }
}