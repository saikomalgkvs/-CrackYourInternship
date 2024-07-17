package Matrix;

import java.util.ArrayList;
import java.util.List;

class Spiralmatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0;
        int left = 0;
        int bottom = n-1;
        int right = m-1;
        
        while(top<=bottom && left<=right){
            //top
            for(int i=left; i<=right; i++){
                list.add(matrix[top][i]);
            }
            top++;
            if(top>bottom){break;}
            //right
            for(int i=top; i<=bottom; i++){
                list.add(matrix[i][right]);
            }
            right--;
            if(left>right){break;}
            //bottom
            for(int i=right; i>=left; i--){
                list.add(matrix[bottom][i]);
            }
            bottom--;
            if(top>bottom){break;}
            //left
            for(int i=bottom; i>=top; i--){
                list.add(matrix[i][left]);
            }
            left++;
            if(left>right){break;}
        }
        return list;
    }
}