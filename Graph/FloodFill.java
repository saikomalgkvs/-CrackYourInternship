public class FloodFill {
    public int[][] floodFill(int[][] mat, int i, int j, int color) {
        boolean[][] vis = new boolean[mat.length][mat[0].length];

        vis[i][j] = true;

        dfs(vis, mat, i,j, i, j+1, color); // right
        dfs(vis, mat, i,j, i, j-1, color); // left
        dfs(vis, mat, i,j, i-1, j, color); // up
        dfs(vis, mat, i,j, i+1, j, color); // down

        mat[i][j] = color;
        return mat;
    }
    public void dfs(boolean[][] vis, int[][] mat, int i, int j, int p, int q, int color){
        if(p<0 || q<0 || p>=mat.length || q>=mat[0].length) return;
        if(mat[i][j] != mat[p][q]) return;
        if(vis[p][q]) return;

        vis[p][q] = true;
        dfs(vis, mat, p,q, p, q+1, color); // right
        dfs(vis, mat, p,q, p, q-1, color); // left
        dfs(vis, mat, p,q, p-1, q, color); // up
        dfs(vis, mat, p,q, p+1, q, color); // down
        mat[p][q] = color;
    }
}
