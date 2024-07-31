// Problem link:
// https://www.geeksforgeeks.org/problems/minimum-swaps/1

import java.util.*;

public class MinimumSwapsToSort {
    public int minSwaps(int nums[]){
        int n = nums.length;
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);
        
        for(int i=0; i<n; i++){
            if(nums[i] != sorted[i]){
                map.put(nums[i], sorted[i]);
            }
        }
        
        // System.out.println(map);
        Queue<Map.Entry<Integer,Integer>> q = new LinkedList<Map.Entry<Integer,Integer>>();
        
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            q.add(e);
        }
        
        Set<Integer> vis = new HashSet<>();
        int swaps = 0;
        while(!q.isEmpty()){
            Map.Entry<Integer,Integer> e = q.poll();
            
            int start = e.getKey();
            int dfs = start;
            
            int count = 0;
            while(!vis.contains(dfs) && map.get(dfs) != start){
                count++;
                vis.add(dfs);
                dfs = map.get(dfs);
            }
            vis.add(dfs);
            // System.out.println(start + " " + count);
            swaps+=count;
        }
        
        return swaps;
    }    
}
