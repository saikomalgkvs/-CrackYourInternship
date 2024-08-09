// Problem link:
// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/

import java.util.Arrays;

public class FindTheCityWithTheSmallestNumber {
    static final int INF = Integer.MAX_VALUE;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];
        
        for(int i=0; i<n; i++){
            Arrays.fill(graph[i], INF); // intialize all distances as INF
            graph[i][i] = 0; // distance between node and itself
        }

        for(int[] edge : edges){
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(graph[i][k] != INF && graph[k][j] != INF && graph[i][j] > graph[i][k] + graph[k][j]){
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }
        for(int[] row : graph){
            System.out.println(Arrays.toString(row));
        }
        int result = 0;
        int minCities = INF;
        for(int i=0; i<n; i++){
            int cities = 0;
            for(int j : graph[i]){
                if(j <= distanceThreshold) cities++;
            }
            if(cities <= minCities){
                minCities = cities;
                result = i;
            }
        }
        return result;
    }
}
