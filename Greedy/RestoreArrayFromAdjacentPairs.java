// Problem link:
// https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RestoreArrayFromAdjacentPairs {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length +1;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int[] edge : adjacentPairs){
            if(map.containsKey((edge[0]))){
                map.get(edge[0]).add(edge[1]);
            }
            else{
                map.put(edge[0], new ArrayList<>(Arrays.asList(edge[1])));
            }

            if(map.containsKey(edge[1])){
                map.get(edge[1]).add(edge[0]);
            }
            else{
                map.put(edge[1], new ArrayList<>(Arrays.asList(edge[0])));
            }
        }

        int start = 0;
        for(Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()){
            if(e.getValue().size() == 1){
                start = e.getKey();
                break;
            }
        }

        int[] ans = new int[n];
        ans[0] = start;

        Set<Integer> vis = new HashSet<>();
        vis.add(start);

        dfs(map, ans, ans[0], 1, vis);
        return ans;
    }
    public void dfs(Map<Integer, ArrayList<Integer>> map, int[] ans, int e, int i, Set<Integer> vis){
        if(i >= ans.length) return;
        ArrayList<Integer> next = map.get(e);
        if(next.size() == 1){
            ans[i] = next.get(0);
        }
        else{
            if(vis.contains(next.get(0))) ans[i] = next.get(1);
            else ans[i] = next.get(0);
        }
        vis.add(ans[i]);
        dfs(map, ans, ans[i], i+1, vis);
    }
}
