package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> p = new ArrayList<>();
        for(int num : nums){
            p.add(num);
        }
        int n = nums.length;

        if(n == 1){
            result.add(p);
            return result;
        }

        helper(result, p, 0, n);
        return result;
    }
    public void helper(List<List<Integer>> result, List<Integer> p, int idx, int n){
        
        if(idx == n) result.add(new ArrayList<>(p));

        Set<Integer> set = new HashSet<>();

        for(int i=idx; i<n; i++){
            if(set.contains(p.get(i))) continue;
            set.add(p.get(i));
            Collections.swap(p,i,idx);
            helper(result, p, idx+1, n);
            Collections.swap(p,i,idx); 
        }
    }
}
