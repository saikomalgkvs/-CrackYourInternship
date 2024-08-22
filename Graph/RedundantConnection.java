// Problem link: https://leetcode.com/problems/redundant-connection/description/ 

public class RedundantConnection {
    int[] rank;
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length; // no.of vertices
        rank = new int[n+1];
        parent = new int[n+1];

        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            int p1 = getParent(edge[0]);
            int p2 = getParent(edge[1]);

            if(p1 == p2) return edge;

            union(p1, p2);
        }
        return new int[]{-1,-1}; // if it is already a tree
    }
    public void union(int p1, int p2){
        if(rank[p1] > rank[p2]){
            parent[p2] = p1;
        }
        else if(rank[p2] > rank[p1]){
            parent[p1] = p2;
        }
        else{
            parent[p1] = p2;
            rank[p2]++;
        }
    }
    public int getParent(int v){
        if(parent[v] == v){
            return v;
        }
        return parent[v] = getParent(parent[v]);
    }
}
