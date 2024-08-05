// Problem link:
// https://leetcode.com/problems/sudoku-solver/

package Backtracking;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }

    private boolean solve(char[][] board, int row, int col){
        if(row == 9) return true;

        if(col == 9) return solve(board, row+1, 0);

        if(board[row][col] != '.') return solve(board, row, col+1);

        for(char num = '1'; num <= '9'; num++){    
            if(isSafe(board, row, col, num)){
                
                board[row][col] = num;
                if(solve(board, row, col+1)) return true;
                board[row][col] = '.';

            }
        }
        return false;
    }
    private boolean isSafe(char[][] board, int row, int col, char num){
        for(int j = 0; j<9; j++){ // check row
            if(board[row][j] == num) return false;
        }

        for(int i = 0; i<9; i++){ // check column
            if(board[i][col] == num) return false;
        }

        int boxi = row - (row % 3);
        int boxj = col - (col % 3);
        for(int i = boxi; i < boxi+3; i++){// check box
            for(int j = boxj; j < boxj+3; j++){
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }
}
