// Problem link: https://leetcode.com/problems/trapping-rain-water/description/

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0) return 0;
        
        int[] left = new int[n];
        int[] right = new int[n];
        int water = 0;
        
        left[0] = height[0];
        for (int i=1; i<n; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }
        
        right[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }
        
        for (int i=0; i<n; i++) {
            int min = Math.min(left[i], right[i]);
            // System.out.print(min - height[i]+" ");
            water += min - height[i];
        }
        
        return water;
    }
}