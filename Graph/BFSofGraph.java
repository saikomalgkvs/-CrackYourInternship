import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSofGraph {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<Integer>();
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        boolean[] visited = new boolean[V];
        visited[0] = true;
        while(!q.isEmpty()){
            int out = q.poll();
            bfs.add(out);
            
            for(int n : adj.get(out)){
                if(!visited[n]){
                    q.add(n);
                    visited[n] = true;
                }
            }
        }
        return bfs;
    }
}
