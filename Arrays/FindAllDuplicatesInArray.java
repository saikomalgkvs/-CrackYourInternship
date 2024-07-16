package Arrays;
/* Find all Duplicates in an Array */

import java.util.*;

class FindAllDuplicatesInArray{
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int[] repeated = new int[n+1];
        for(int e:nums){
            repeated[e]++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            if(repeated[i]==2){
                ans.add(i);
            }
        }
        return ans;
    }
}
