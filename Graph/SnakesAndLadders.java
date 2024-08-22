// Problem link: https://leetcode.com/problems/snakes-and-ladders/description/

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int V = n * n; // total cells on the board

        // perform BFS
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V + 1];
        q.add(1);
        visited[1] = true;
        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int curr = q.poll();
                
                if(curr == V) return steps;

                for(int dice = 1; dice <= 6; dice++){
                    int next = curr + dice;
                    if (next > V) break;

                    int[] pos = getBoardPosition(next, n);
                    int r = pos[0], c = pos[1];

                    if(board[r][c] != -1) next = board[r][c];

                    if(!visited[next]){
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private int[] getBoardPosition(int index, int n) {
        int row = (index - 1) / n;
        int col = (index - 1) % n;
        if (row % 2 == 1) col = n - 1 - col;
        return new int[]{n - 1 - row, col};
    }
}
