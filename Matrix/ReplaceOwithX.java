package Matrix;

// Replace O's with X's
public class ReplaceOwithX {
    static char[][] fill(int n, int m, char a[][])
    {
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i][j] == 'O') a[i][j] = 'K';
            }
        }
        // change top and bottom edges
        for(int i=0; i<m; i++){
            if(a[0][i] == 'K') dfs(a, 0, i,'K','O');
            if(a[n-1][i] == 'K') dfs(a, n-1, i,'K','O');
        }
        
        // change left and right edges
        for(int j=0; j<n; j++){
            if(a[j][0] == 'K') dfs(a, j, 0,'K','O');
            if(a[j][m-1] == 'K') dfs(a, j, m-1,'K','O');
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i][j] == 'K') dfs(a, i, j,'K','X');
            }
        }
        return a;
    }
    static void dfs(char[][] a, int i, int j, char from, char to){
        if(i<0 || j<0 || i>=a.length || j>=a[0].length) return;
        if(a[i][j] == from) a[i][j] = to;
        else return;
        
        dfs(a, i, j+1, from, to); // right
        dfs(a, i+1, j, from, to); // down
        dfs(a, i, j-1, from, to); // left
        dfs(a, i-1, j, from, to); // up
    }    
}
