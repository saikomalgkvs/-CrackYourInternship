package Arrays;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] newboard = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){ 
                newboard[i][j] = change(board, i, j);
            }
        }
        for(int i=0; i<n; i++){
            board[i] = newboard[i];
        }
    }
    public int change(int[][] m, int i, int j){
        int ones = get(m,i,j+1) + get(m,i+1,j) +get(m,i-1,j) +get(m,i,j-1) +get(m,i+1,j+1) +get(m,i-1,j-1) +get(m,i+1,j-1) +get(m,i-1,j+1); 
        if(m[i][j] == 0 && ones == 3) return 1;
        if(m[i][j] == 1 && (ones < 2 || ones > 3)) return 0;
        return m[i][j];
    }
    public int get(int[][] m, int i, int j){
        if(i<0 || j<0 || i>=m.length || j>=m[0].length) return 0;
        return m[i][j];
    }
}
