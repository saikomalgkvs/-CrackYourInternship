import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        for(int num : nums){
            int pos = binarySearch(lis, num);
            if (pos < lis.size()) lis.set(pos, num);
            else lis.add(num);
        }
        return lis.size();
    }

    private int binarySearch(List<Integer> lis, int num){
        int low = 0;
        int high = lis.size();

        while(low < high){
            int mid = low + (high - low) / 2;
            if(lis.get(mid) < num) low = mid + 1;
            else high = mid;
        }
        
        return low;
    }
}
