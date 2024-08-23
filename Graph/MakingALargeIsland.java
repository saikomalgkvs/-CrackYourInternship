// Problem link: https://leetcode.com/problems/making-a-large-island/description/

import java.util.HashSet;
import java.util.Set;

class MakingALargeIsland {
    int[] parent;
    int[] size;
    int maxSize;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        parent = new int[m*n];
        size = new int[m*n];

        maxSize = 0;
        boolean isEmpty = true;
        boolean isFull = true;

        for(int i=0;i<parent.length;i++){
            int r = i/m;
            int c = i%n;
            if(grid[r][c] == 1){
                parent[i] = i;
                size[i] = 1;
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    isEmpty = false;
                    int x = i*m + j;
                    int x1 = i*m + j - 1;
                    int x2 = (i-1)*m + j;
                    if(j != 0 && grid[i][j - 1] == 1) union(x, x1);
                    if(i != 0 && grid[i-1][j] == 1) union(x, x2);
                }
                else isFull = false;
            }
        }

        if(isEmpty) return 1;
        if(isFull) return m*n;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Set<Integer> visited = new HashSet<>();

                if(grid[i][j] == 0){
                    int cSize = 1;

                    for(int k=0; k<4; k++) {
                        int nexti = i + dx[k];
                        int nextj = j + dy[k];
                        if (nexti >= 0 && nexti < m && nextj >= 0 && nextj < n && grid[nexti][nextj] == 1) {
                            int x1 = (nexti)*m + (nextj);
                            int p1 = find(x1);
                            if (!visited.contains(p1)) {
                                cSize += size[p1];
                                visited.add(p1);
                            }
                        }
                    }

                    maxSize = Math.max(maxSize, cSize);
                }
            }
        }

        return maxSize;
    }

    private void union(int x1, int x2){
        int p1 = find(x1);
        int p2 = find(x2);

        if (p1 != p2){
            if (size[p1] > size[p2]){
                parent[p2] = p1;
                size[p1] += size[p2];
            }
            else{
                parent[p1] = p2;
                size[p2] += size[p1];
            }
        }
    }

    private int find(int p){
        if (parent[p] == p){
            return p;
        }

        return parent[p] = find(parent[p]);
    }
}