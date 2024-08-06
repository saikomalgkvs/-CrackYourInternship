// Problem link:
// https://leetcode.com/problems/unique-paths-iii/description/

package Backtracking;

public class UniquePathsIII {
    private int[][] grid;
    private int m, n;
    private int totalZeros;
    private int paths;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.totalZeros = 0;
        this.paths = 0;
        
        int startX = 0;
        int startY = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                }
                else if(grid[i][j] == 0) totalZeros++;
            }
        }

        backtrack(startX, startY, -1);
        return paths;
    }

    private void backtrack(int x, int y, int count){
        if(grid[x][y] == 2){
            if(count == totalZeros) paths++;
            return;
        }
        int temp = grid[x][y];
        grid[x][y] = -1;

        for(int i = 0; i < 4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(isValid(newX, newY)) backtrack(newX, newY, count + 1);
        }
        grid[x][y] = temp;
    }

    private boolean isValid(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n && (grid[x][y] == 0 || grid[x][y] == 2);
    }
}
