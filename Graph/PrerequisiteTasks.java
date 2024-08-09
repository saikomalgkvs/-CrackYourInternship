// Problem link:
// https://www.geeksforgeeks.org/problems/prerequisite-tasks/1

public class PrerequisiteTasks {
    public boolean isPossible(int N,int P, int[][] prerequisites){
        boolean[][] graph = new boolean[N][N];
        
        for(int[] prereq : prerequisites){
            graph[prereq[1]][prereq[0]] = true;
        }
        
        // for(boolean[] row : graph){
        //     System.out.println(Arrays.toString(row));
        // }
        
        boolean[] vis = new boolean[N];
        boolean[] vis2 = new boolean[N];
        for(int node = 0; node < N; node++){
            if(!vis[node] && cycleExists(node, graph, vis, vis2)) return false;
        }
        
        return true;
    }
    private boolean cycleExists(int node, boolean[][] graph, boolean[] vis, boolean[] vis2){
        if(vis2[node]) return true; // cycle exists
        if(vis[node]) return false; // already explored node
        
        vis2[node] = true;
        vis[node] = true;
        
        for(int i=0; i<graph.length; i++){
            if(graph[node][i] && cycleExists(i, graph, vis, vis2)){
                return true;
            }
        }
        vis2[node] = false;
        return false;
    }
}
