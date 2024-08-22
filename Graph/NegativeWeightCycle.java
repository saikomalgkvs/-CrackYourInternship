// Problem link: https://www.geeksforgeeks.org/problems/negative-weight-cycle3504/1

import java.util.Arrays;

public class NegativeWeightCycle {
    final static int INF = Integer.MAX_VALUE;
    public int isNegativeWeightCycle(int n, int[][] edges) {
    
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for(int i = 1; i < n; i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (dist[u] != INF && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if(dist[u] + wt < dist[v]) return 1;
        }
        return 0;
    }
}
