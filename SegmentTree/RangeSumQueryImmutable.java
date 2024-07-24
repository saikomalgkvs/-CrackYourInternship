// Range Sum Query - Immutable

class NumArray {
    int[] prefixsum;
    int[] arr;
    public NumArray(int[] nums) {
        prefixsum = new int[nums.length];
        arr = nums;
        int sum = nums[0];
        prefixsum[0] = sum;

        for(int i=1; i<nums.length; i++){
            sum += nums[i];
            prefixsum[i] = sum;
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixsum[right] - prefixsum[left] + arr[left];
    }
}
