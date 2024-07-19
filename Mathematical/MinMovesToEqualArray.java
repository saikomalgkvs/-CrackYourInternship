package Mathematical;

import java.util.Arrays;

public class MinMovesToEqualArray {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int median = nums[n/2];
        int moves = 0;
        for(int i : nums){
            moves += Math.abs(i - median);
        }
        return moves;
    }
}
