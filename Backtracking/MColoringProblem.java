// Problem link:
// https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1

package Backtracking;

public class MColoringProblem {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // n - no. of vertices in graph
        // m - minimum required colors

        int[] color = new int[n]; // array consists which node is colored to which color.
        return canColor(graph, color, m, 0, n); // 0 - starting from node 0.
    }
    private boolean canColor(boolean[][] graph, int[] color, int m, int i, int n){
        if(n == i) return true; // return's true when all nodes are colored.
        
        for(int c=1; c<=m; c++){ // c represents color,
            if(isSafe(graph, i, c, color, n)){
                color[i] = c;
                if(canColor(graph, color, m, i+1, n)) return true;
                color[i] = 0;
            }
        }
        return false;
    }
    private boolean isSafe(boolean[][] graph, int i, int c, int[] color, int n){ // i is ith node, c is color to be assigned to ith node
        for(int v = 0; v < n; v++){
            if(graph[i][v] && c == color[v]) return false;
        }
        return true;
    }    
}
