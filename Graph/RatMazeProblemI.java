package Graph;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Iterator;

public class RatMazeProblemI {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> paths = new ArrayList<String>();
        Stack<Character> path = new Stack<Character>();
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        
        backtrack(paths, mat,0,0, path, 'x', vis);
        return paths;
    }
    private void backtrack(ArrayList<String> paths, int[][] mat,int i,int j, Stack<Character> path, char c, boolean[][] vis){
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length) return;
        if(vis[i][j]) return;
        if(mat[i][j] == 1){
            path.push(c);
            vis[i][j] = true;
        }
        else return;
        
        if(i==mat.length-1 && j==mat.length-1){
            StringBuilder sb = new StringBuilder();
            Iterator<Character> itr = path.iterator();
            while(itr.hasNext()) sb.append(itr.next());
            sb.replace(0,1,""); // to remove 'x' in the starting
            paths.add(sb.toString());
        }
        backtrack(paths, mat, i+1, j, path, 'D', vis);
        backtrack(paths, mat, i, j-1, path, 'L', vis);
        backtrack(paths, mat, i-1, j, path, 'U', vis);
        backtrack(paths, mat, i, j+1, path, 'R', vis);
        path.pop();
        vis[i][j] = false;
    }
}
