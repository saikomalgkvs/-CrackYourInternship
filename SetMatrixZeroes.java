import java.util.*; 
class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> lst = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) lst.add(new int[]{i,j});
            }
        }
        helper(matrix, lst);
    }
    private void helper(int[][] matrix, List<int[]> lst){
        for(int[] cord : lst){
            int i=cord[0];
            int j=cord[1];
            for(int col=0; col < matrix[0].length; col++){
                matrix[i][col] = 0;
            }
            for(int row=0; row < matrix.length; row++){
                matrix[row][j] = 0;
            }
        }
    }
}