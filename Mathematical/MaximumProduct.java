package Mathematical;

import java.util.Arrays;

public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int c = nums[n-1] * nums[n-2] * nums[n-3];
        if(n==3 || nums[0]>0) return c;

        int b = nums[0] * nums[1] * nums[n-1];
        int a = nums[0] * nums[1] * nums[2];

        int max1 = (a>b)? a:b;
        int max2 = (max1>c)? max1:c;

        return max2;
    }
}
