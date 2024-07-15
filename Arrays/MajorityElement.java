package Arrays;
import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        int n = nums.length;
        int c = n/2;
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
            if(map.get(i) > c){
                return i;
            }
        }
        return -1;
    }
}
