// Problem link:
// https://leetcode.com/problems/maximum-product-subarray/description/

public class MaxProductSubaray {
    public int maxProduct(int[] nums) {
        double prod = 1;
        double a = Integer.MIN_VALUE;

        for(int i : nums){
            prod *= i;
            a = Math.max(a, prod);

            if(prod == 0) prod = 1;
        }

        prod = 1;
        double b = Integer.MIN_VALUE;

        for(int i=nums.length-1; i>=0; i--){
            prod *= nums[i];
            b = Math.max(b, prod);

            if(prod == 0) prod = 1;
        }
        return (int) (Math.max(a,b));
    }
}
