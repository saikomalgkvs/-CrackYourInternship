package Heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestSubarrayWith0Sum {
    int maxLen(int arr[], int n){
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        int sum = 0;
        int max = 0;
        
        for(int i=0; i<n; i++){
            sum += arr[i];
            
            if(map.containsKey(sum)){
                map.get(sum).add(i);
            }
            else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(sum, list);
            }
            
        }
        for(Map.Entry<Integer,List<Integer>> e : map.entrySet()){
            List<Integer> value = e.getValue();
            if(e.getKey() == 0) max = Math.max(max, value.get(value.size()-1)+1);
            else if(value.size() > 1){
                max = Math.max(max, value.get(value.size()-1) - value.get(0));
            }
        }
        return max;
    }
}
