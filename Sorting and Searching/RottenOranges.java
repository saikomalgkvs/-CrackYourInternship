// Problem link:
// https://www.geeksforgeeks.org/problems/rotten-oranges2536/1

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int i;
    int j;
    
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}

class RottenOranges{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid){
        int fresh = 0;
        int rotten = 0;
        
        int n = grid.length;
        int m = grid[0].length;
        
        for(int[] row : grid){
            for(int orange : row){
                if(orange == 1) fresh++;
                if(orange == 2) rotten++;
            }
        }
        if(rotten == 0) return 0;
        
        int time = 0;
        Queue<Pair> q = new LinkedList<Pair>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2) q.add(new Pair(i,j));
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Pair out = q.poll();
                q.addAll(rott(grid, out.i, out.j, n, m));
            }
            fresh -= q.size();
            time++;
        }
        
        return (fresh == 0) ? time-1 : -1;
    }
    private Queue<Pair> rott(int[][] grid, int i, int j, int n, int m){
        Queue<Pair> q = new LinkedList<Pair>();
        
        if(i-1 >=0 && i-1 < n && grid[i-1][j] == 1){
            grid[i-1][j] = 2;
            q.add(new Pair(i-1,j));
        }
        if(i+1 >=0 && i+1 < n && grid[i+1][j] == 1){
            grid[i+1][j] = 2;
            q.add(new Pair(i+1,j));
        }
        if(j-1 >=0 && j-1 < m && grid[i][j-1] == 1){
            grid[i][j-1] = 2;
            q.add(new Pair(i,j-1));
        }
        if(j+1 >=0 && j+1 < m && grid[i][j+1] == 1){
            grid[i][j+1] = 2;;
            q.add(new Pair(i,j+1));
        }
        return q;
    }
}
