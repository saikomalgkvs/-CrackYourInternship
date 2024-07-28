package Graph;

import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

// Problem link:
// https://leetcode.com/problems/shortest-bridge/description/

public class ShortestBridge {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;

        int firstX = -1;
        int firstY = -1;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    firstX=i;
                    firstY=j;
                    break;
                }
            }
        }
        dfs(grid,firstX,firstY); // changing one island from 1 to 2;

        Queue<Pair<Integer,Integer>> q=new LinkedList(); // collecting elements of first island

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2) q.offer(new Pair(i,j));
            }
        }

        int lev=0;
        while(!q.isEmpty()){
            lev++;
            int size = q.size();
            while(size-- > 0)
            {
                Pair<Integer,Integer> pair = q.poll();
                int [] row = {-1,0,1,0};
                int [] col = {0,1,0,-1};

                for(int i=0; i<4; i++){
                    int x = pair.getKey() + row[i];
                    int y = pair.getValue() + col[i];

                    if(x >= 0 && y >= 0 && x < n && y<n){
                        if(grid[x][y] == 0){
                            grid[x][y] = 2;
                            q.offer(new Pair(x ,y));
                        }
                        if(grid[x][y] == 1) return lev-1;
                    }
                }
            }
        }
        return 0;
    }
    public void dfs(int[][] graph,int i,int j){
        if(i<0 || j<0 || i>=graph.length || j>=graph.length || graph[i][j]==0 || graph[i][j]==2) return;
        graph[i][j]=2;

        dfs(graph,i+1,j);
        dfs(graph,i,j+1);
        dfs(graph,i-1,j);
        dfs(graph,i,j-1);  
    }
}
