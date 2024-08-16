// Problem link: https://leetcode.com/problems/delete-and-earn/

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 1) return nums[0];

        int max = 0;
        for(int i : nums){
            max = Math.max(max,i);
        }

        int dp[] = new int[max+1];
        for(int i : nums){
            dp[i] += i;
        }

        for(int i =2; i <= max; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + dp[i]);
        }
        return dp[max];
    }
}
