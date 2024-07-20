package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsII {
    List<List<Integer>> result;

    SubsetsII(){
        result = new ArrayList<>();
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        helper(nums, 0, subset, n);
        return result;
    }
    public void helper(int[] nums, int i, List<Integer> subset, int n){
        if(i == n){
            if(result.contains(subset)) return;
            result.add(new ArrayList<>(subset));
            return;
        }
        helper(nums, i+1, subset, n);

        subset.add(nums[i]);
        helper(nums, i+1, subset, n);
        subset.remove(subset.size()-1);

    }
}
