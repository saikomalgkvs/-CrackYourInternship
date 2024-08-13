package Strings;

import java.util.HashMap;

public class WordWrap {
    public int solveWordWrap (int[] nums, int k){
        HashMap<String , Integer> hm  = new HashMap<>();
        return wordWrap(k , 0 , nums , k , hm); 
    }
    
    public static int wordWrap(int remain , int i, int [] nums, int k , HashMap<String , Integer> hm){
        if(i == nums.length) return 0;
        
        if(hm.get(i + ":" + remain) != null) return hm.get(i + ":" + remain);
        
        int ans;
        if(nums[i] > remain){
            ans =   (int)Math.pow(remain + 1 , 2) + wordWrap(k - nums[i] - 1, i+1 , nums , k , hm);
            hm.put(i + ":" + remain , ans);
            return ans;
        }
        else{
            int choice1 = (int)Math.pow(remain + 1 , 2) + wordWrap(k - nums[i] - 1,i+1 , nums , k , hm);
            int choice2 = wordWrap(remain - nums[i] - 1,i+1 , nums , k , hm);
            ans =  Math.min(choice1 , choice2);
            hm.put(i + ":" + remain , ans);
            return ans;
        }
    }
}
