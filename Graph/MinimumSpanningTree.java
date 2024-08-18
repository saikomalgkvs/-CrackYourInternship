// Problem link: https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1

import java.util.List;
import java.util.PriorityQueue;

class Edge{
    int start;
    int end;
    int weight;
    
    Edge(int s, int e, int w){
        start = s;
        end = e;
        weight = w;
    }
    public String toString(){
        return "[" + start +","+ end +","+ weight +"]";
    }
}
class MinimumSpanningTree{
    static int[] rank;
    static int[] parent;
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        rank = new int[V];
        parent = new int[V];
        for(int i=0; i<V; i++) parent[i] = i;
        
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((a,b) -> a.weight - b.weight);
        
        boolean[] added = new boolean[V];
        for(int v = 0; v < V; v++){
            for(int[] i : adj.get(v)){
                if(added[i[0]]) continue;
                Edge edge = new Edge(v, i[0], i[1]);
                pq.add(edge);
            }
            added[v] = true;
        }
        
        int spanningTreeLength = 0;
        int edgesAdded = 0;
        
        while(edgesAdded < V - 1){
            Edge out = pq.poll();
            
            int r1 = findRoot(out.start);
            int r2 = findRoot(out.end);
            
            if(r1 != r2){
                spanningTreeLength += out.weight;
                edgesAdded++;
                union(r1,r2);
            }
            
        }
        return spanningTreeLength;
    }
    static int findRoot(int v){
        if(parent[v] == v) return v;
        parent[v] = findRoot(parent[v]);
        return parent[v];
    }
    static void union(int node1, int node2){
        // check if both have same parents
        int p1 = findRoot(node1);
        int p2 = findRoot(node2);
        if(p1 == p2) return;
        
        // compare ranks
        if(rank[p1] > rank[p2]){
            parent[p2] = p1; 
        }
        else if(rank[p1] < rank[p2]){
            parent[p1] = p2; 
        }
        else{// if ranks are equal
            parent[p1] = p2;
            rank[p2]++;
        }
    }
}