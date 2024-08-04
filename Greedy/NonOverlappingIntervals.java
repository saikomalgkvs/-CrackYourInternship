// Problem link:
// https://leetcode.com/problems/non-overlapping-intervals/description/
import java.util.Arrays;

public class NonOverlappingIntervals  {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        int n = intervals.length;

        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        int prev = intervals[0][1];
        for (int i=1; i<n; i++){
            if (prev > intervals[i][0]) res++;
            else prev = intervals[i][1];
        }

        return res;        
    }
}
