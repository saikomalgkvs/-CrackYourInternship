// Problem link:
// https://leetcode.com/problems/as-far-from-land-as-possible/description/

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) q.add(new int[]{i, j});
            }
        }
        
        if(q.size() == m*n) return -1;
            
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            for(int i = 0; i < size; i++){
                int[] out = q.poll();
                int row = out[0];
                int col = out[1];

                for(int j=0; j<4; j++){
                    int nextx = row + x[j];
                    int nexty = col + y[j];
                    if(nextx >= 0 && nextx < m && nexty >=0 && nexty < n && grid[nextx][nexty] == 0){
                       grid[nextx][nexty] = 1;
                       q.add(new int[]{nextx, nexty});
                    } 
                }  
            }
        }
        return dist - 1;
    }
}
