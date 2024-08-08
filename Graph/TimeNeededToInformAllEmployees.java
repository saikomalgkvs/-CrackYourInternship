// Problem link:
// https://leetcode.com/problems/time-needed-to-inform-all-employees/description/

import java.util.ArrayList;

public class TimeNeededToInformAllEmployees {
    int time;
    int maxtime;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // solving with directed graph
        ArrayList<Integer>[] list = new ArrayList[n];

        for(int i=0; i<n; i++) list[i] = new ArrayList<>(); // initialize adjacency list

        for(int i=0; i<n; i++){
            if(manager[i] == -1) continue;
            list[manager[i]].add(i);
        }

        dfs(headID, list, informTime);
        return maxtime;
    }
    private void dfs(int node, ArrayList<Integer>[] list, int[] informTime){
        if(list[node].size() == 0){
            maxtime = Math.max(maxtime, time);
            return;
        }
        time += informTime[node];
        for(int nextNode : list[node]){
            dfs(nextNode, list, informTime);
        }
        time -= informTime[node];
    }
}
