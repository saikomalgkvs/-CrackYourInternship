package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        func(nums, subset, 0);
        return list;
    }
    public void func(int[] nums, List<Integer> subset, int start){
        if(start == nums.length){
            list.add(new ArrayList<>(subset));
            return;
        }
        func(nums, subset, start+1);
        subset.add(nums[start]);
        func(nums, subset, start+1);
        subset.remove((Integer) nums[start]);
    }
}
