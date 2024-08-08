public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, visited);
                } 
            }
        }
        return count; 
    }
    private void dfs(char[][] grid, int i, int j, boolean[][] visit){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == '0' || visit[i][j]){
            return;
        }

        visit[i][j] = true;

        dfs(grid, i, j-1, visit); // mark left as visited
        dfs(grid, i, j+1, visit); // mark right as visited
        dfs(grid, i-1, j, visit); // mark up as visited
        dfs(grid, i+1, j, visit); // mark down as visited
    }
}
