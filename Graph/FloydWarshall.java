// Problem link:
// https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1

public class FloydWarshall {
    static final int INF = Integer.MAX_VALUE;
    
    public void shortest_distance(int[][] matrix){
        int v = matrix.length;
        
        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                if(matrix[i][j] == -1) matrix[i][j] = INF;
            }
        }
        
        for(int k = 0; k < v; k++){
            for(int i = 0; i < v; i++){
                for(int j = 0; j < v; j++){
                    if(matrix[i][k] != INF && matrix[k][j] != INF && matrix[i][k] + matrix[k][j] < matrix[i][j]){
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
        
        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                if(matrix[i][j] == INF) matrix[i][j] = -1;
            }
        }
        
    }    
}
