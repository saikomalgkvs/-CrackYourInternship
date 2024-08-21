// Problem link: https://leetcode.com/problems/swim-in-rising-water/

package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[2] - b[2]));

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        
        for(boolean[] i : visited){
            Arrays.fill(i,false);
        }

        pq.add(new int[]{0, 0, grid[0][0]});
        while(!pq.isEmpty()){
            int[] out = pq.poll();

            if(visited[out[0]][out[1]]) continue;
            if(out[0] == n - 1 && out[1] == n - 1) return out[2];

            visited[out[0]][out[1]] = true;

            for(int[] i : directions){
                int x = out[0] + i[0], y = out[1] + i[1];
                if(x >= 0 && y >= 0 && x < n && y < n && !visited[x][y]){ // checking if in boundary and not visited.
                    pq.offer(new int[]{ x, y, Math.max(out[2], grid[x][y])});
                }
            }

        }
        return 0;
    }
}
