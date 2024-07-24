package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();

        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }
        backtrack(board, 0, 0, n);
        return result;
    }
    public void backtrack(char[][] board, int row, int col, int n){
        if(row == n){
            List<String> sol = new ArrayList<>();
            for(char[] line : board){
                String str = new String(line);
                sol.add(str);
            }
            result.add(sol);
            return;
        }
        for(int j=col; j<n; j++){
            if(isSafe(board, row, j, n)){
                board[row][j] = 'Q';
                backtrack(board, row+1, 0, n);
                board[row][j] = '.';
            }
        }
    }
    public boolean isSafe(char[][] board, int i, int j, int n){

        //check top
        for(int row = i; row>=0; row--){
            if(board[row][j] == 'Q') return false;
        }

        // check left diagonal
        int row = i-1;
        int col = j-1;
        while(row >= 0 && col >= 0){
            if(board[row--][col--] == 'Q') return false;
        }

        // check right diagonal
        row = i-1;
        col = j+1;
        while(row >= 0 && col < n){
            if(board[row--][col++] == 'Q') return false;
        }

        return true;
    }
}
