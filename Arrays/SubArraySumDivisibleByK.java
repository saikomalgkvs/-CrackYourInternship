package Arrays;

/* find the number of Subarrays whose sum is divisible by K */

import java.util.HashMap;
import java.util.Map;

public class SubArraySumDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            sum %= k;

            if(sum<0) sum+=k;

            if(map.containsKey(sum)) count += map.get(sum);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
