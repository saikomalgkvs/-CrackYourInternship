package Arrays;

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int[] count = new int[3];

        for(int i : nums){
            if(i==0) count[0]++;
            else if(i==1) count[1]++;
            else count[2]++;
        }
        int i=0;
        for(int a=0 ; a<count[0]; a++){
            nums[i] = 0;
            i++;
        }
        for(int b=0 ; b<count[1]; b++){
            nums[i] = 1;
            i++;
        }
        for(int c=0 ; c<count[2]; c++){
            nums[i] = 2;
            i++;
        }
    }
}