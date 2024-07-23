package Matrix;

public class FindNumberOfIslands {
    final int[] row = {-1,-1,-1, 0, 0, 1, 1, 1};
    final int[] col = {-1, 0, 1,-1, 1,-1, 0, 1};
    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        int islands = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(grid, vis, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    public boolean canExplore(char[][] grid, boolean[][] vis, int i, int j){
        return (i>=0) && (j>=0) && (i<grid.length) && (j<grid[0].length) && (grid[i][j] == '1') && (!vis[i][j]);
    }
    public void dfs(char[][] grid, boolean[][] vis, int i, int j){
        vis[i][j] = true;
        
        for(int idx=0; idx<8; idx++){
            if(canExplore(grid, vis, i+row[idx], j+col[idx])){
                dfs(grid, vis, i+row[idx], j+col[idx]);
            }
        }
    }
}
