// Rat Maze With Multiple Jumps
// Problem link:
// https://www.geeksforgeeks.org/problems/rat-maze-with-multiple-jumps3852/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

package Backtracking;

class FindPathsFromCorner{
    public int[][] ShortestDistance(int[][] matrix){
        int[][] path = new int[matrix.length][matrix[0].length];
        
        if(!findPath(matrix, 0, 0, path)) return new int[][]{{-1}};
        
        return path;
    }
    
    private boolean isSafe(int[][] matrix, int r, int c) {
        if(r >= matrix.length || c >= matrix[0].length || matrix[r][c] == 0) {
            return false;
        }
        
        return true;
    } 
    
    private boolean findPath(int[][] matrix, int r, int c, int[][] path) {
        if(r == matrix.length-1 && c == matrix[0].length-1) {
            path[r][c] = 1;
            return true;
        }
        
        if(isSafe(matrix, r, c)) {
            path[r][c] = 1;
            
            for(int i=1;i<=matrix[r][c];i++) {
                if(findPath(matrix, r, c+i, path)) {
                    return true;
                }
                
                if(findPath(matrix, r+i, c, path)) {
                    return true;
                }
            }
            
            path[r][c] = 0;
        }
        
        return false;
    }
}