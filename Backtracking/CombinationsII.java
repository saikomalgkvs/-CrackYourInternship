package Backtracking;

import java.util.*;

class CombinationsII {
    List<List<Integer>> comb;
    ArrayList<Integer>[] map;
    CombinationsII(){
        comb = new ArrayList<>();
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        map = new ArrayList[candidates.length];
        helper(candidates, target, 0,0, new ArrayList<>());
        return comb;
    }

    public void helper(int[] cand, int target, int currsum, int idx, List<Integer> arr){
        if(idx!=map.length) {
            if(map[idx] != null && map[idx].equals(arr)) return;
            ArrayList<Integer> val = new ArrayList<>(arr);
            map[idx] = val;

            // System.out.println(idx + " " + map[idx]);
        }

        if(currsum == target){
            List<Integer> permutation = new ArrayList<>(arr);
            Collections.sort(permutation);
            if(comb.contains(permutation)) return;
            comb.add(permutation);
            return;
        }
        if(idx >= cand.length) return;
        if(currsum >= target) return;

        helper(cand, target, currsum, idx+1, arr);

        arr.add(cand[idx]);
        helper(cand, target, currsum+cand[idx], idx+1, arr);
        arr.remove(arr.size()-1);
    }
}