// Problem link:
// https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/

import java.util.*;

class CountSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        
        List<Integer> sorted = new ArrayList<>();
        List<Integer> smaller = new ArrayList<>();
        sorted.add(nums[n-1]);
        smaller.add(0);

        for(int i=n-2; i>=0; i--){
            smaller.add(binarySearch(sorted, 0, sorted.size()-1, nums, i));
            // System.out.println(sorted);
            // System.out.println(smaller);
        }
        Collections.reverse(smaller);
        return smaller;
    }
    private int binarySearch(List<Integer> sorted, int start, int end, int[] nums, int i){

        int mid = start + (end - start)/2;

        if(start >= end){
            if(sorted.get(start) < nums[i]){
                sorted.add(start+1, nums[i]);
                return start+1;
            }
            else{
                sorted.add(start, nums[i]);
                return start;
            }
        }
        else if(nums[i] <= sorted.get(mid)){
            return binarySearch(sorted, start, mid-1, nums, i);
        }
        else{
            return binarySearch(sorted, mid+1, end, nums, i);
        }
    }
}