package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>(); 
        
        Arrays.sort(nums); 
        
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> arr = new ArrayList<>();
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        arr.add(nums[left]);
                        arr.add(nums[right]);
                        
                        if (!resultSet.contains(arr)) {
                            resultSet.add(arr); 
                        }
                        
                        left++;
                        right--;
                    } else if (sum <= target) {
                        left++;
                    } else if(sum > target){
                        right--;
                    }
                }
            }
        }
        
        result.addAll(resultSet); 
        
        return result;
    }
}
