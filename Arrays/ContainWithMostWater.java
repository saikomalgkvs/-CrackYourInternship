package Arrays;

class ContainerWithMostWater{
    public int maxArea(int[] height) {
        int water = Integer.MIN_VALUE;

        int n = height.length;
        int i = 0;
        int j = n-1;

        while(i < j){
            int min = Math.min(height[i], height[j]);
            water = Math.max(water, min*(j-i));

            while(height[i] <= min && i<j) i++;
            while(height[j] <= min && i<j) j--;
        }
        return water;
    }
}