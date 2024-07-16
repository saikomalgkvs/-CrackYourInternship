package Arrays;
class MoveZeros {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) return;

        int i=0;
        int p=0;

        while(i<nums.length){
            if(nums[i] !=0){
                if(i!=p){
                    nums[p] = nums[i];
                    nums[i] = 0;
                }
                p++;
            }
            i++;
        }
    }
}