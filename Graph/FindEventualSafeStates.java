// Problem link: https://leetcode.com/problems/find-eventual-safe-states/description/

import java.util.*;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> result = new ArrayList<>();
        int[] state = new int[n]; // 0: unvisited, 1: visiting, 2: safe

        // perform dfs from all nodes
        for(int i = 0; i < n; i++){
            if(isSafe(i, graph, state)){
                result.add(i);
            }
        }

        Collections.sort(result);
        return result;
    }

    private boolean isSafe(int node, int[][] graph, int[] state) {
        if(state[node] != 0) return state[node] == 2;
        state[node] = 1; // visited

        for(int nextNode : graph[node]){
            if(state[nextNode] == 2) continue; // skip safe nodes
            if(state[nextNode] == 1 || !isSafe(nextNode, graph, state)) return false;
        }

        state[node] = 2; // safe
        return true;
    }
}
