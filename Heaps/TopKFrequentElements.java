package Heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequentElemetns {
    
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];

        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((e1,e2) -> e2.getValue() - e1.getValue());
        queue.addAll(map.entrySet());
        for(int i=0; i<k; i++){
            ans[i] = queue.poll().getKey();
        }
        return ans;
    }
}