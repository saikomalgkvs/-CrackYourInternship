// Problem link: https://www.geeksforgeeks.org/problems/bipartite-graph/1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj){
        int[] color = new int[V]; // we will color with colors 0 and 1, -1 means not colored
        Arrays.fill(color, -1);
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        color[0] = 1;
        
        for(int i=0; i<V; i++){
            if(color[i] == -1){
                q.add(i);
                color[i] = 0;
                
                while(!q.isEmpty()){
                    int out = q.poll();
                    for(int nextNode : adj.get(out)){
                        if(color[nextNode] == -1){
                            color[nextNode] = (color[out] + 1) % 2;
                            q.add(nextNode);
                        }
                        else if(color[out] == color[nextNode]) return false;
                    }
                }
            }
        }
        
        return true;
    }    
}