package Arrays;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] jumps = new boolean[n];
        jumps[n-1] = true;

        int destination = n-1;
        for(int i=n-2; i>=0; i--){
            if(i + nums[i] >= destination){
                jumps[i] = true;
                destination = i;
            }
        }
        return jumps[0];
    }
}
