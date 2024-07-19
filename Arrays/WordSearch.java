package Arrays;

public class WordSearch{
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        char[] c = word.toCharArray();
        boolean[][] vis = new boolean[n][m];

        boolean found = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == c[0]){
                    found = found || helper(board, c, vis, i, j, 0);
                }
                vis = new boolean[n][m];
            }
        }
        return found;

    }
    public boolean helper(char[][] board, char[] word, boolean[][] vis, int i, int j, int idx){
        if(idx == word.length) return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return false;
        if(vis[i][j] == true) return false;
        boolean check = board[i][j] == word[idx];
        if(check){
            vis[i][j] = true;
            boolean a = helper(board, word, vis, i, j+1, idx+1); // right
            boolean b = helper(board, word, vis, i, j-1, idx+1); // left
            boolean c = helper(board, word, vis, i+1, j, idx+1); // down
            boolean d = helper(board, word, vis, i-1, j, idx+1); // up
            vis[i][j] = false;
            return a || b || c || d;
        }
        else return false;

    }
}