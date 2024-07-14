package Arrays;
import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int find = target - nums[i];
            if(map.containsKey(find)) return new int[]{i, map.get(find)};
            map.put(nums[i],i);
        }

        return new int[]{};
    }
}
