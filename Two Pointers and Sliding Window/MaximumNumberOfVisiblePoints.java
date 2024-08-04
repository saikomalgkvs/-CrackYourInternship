import java.util.*;

public class MaximumNumberOfVisiblePoints {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location){
        List<Double> angles = new ArrayList<>();
        int countOfSameLoc = 0;
        for(List<Integer> point : points){
            int dx = point.get(0) - location.get(0); 
            int dy = point.get(1) - location.get(1);
            
            if(dx == 0 && dy == 0) countOfSameLoc++;
            else{
                double degree = Math.atan2(dy, dx)*(180/Math.PI);
                angles.add(degree);
            }
        }
        
        Collections.sort(angles);
        
        int n = angles.size();
        for(int i = 0; i < n; i++){
            angles.add(angles.get(i) + 360);
        }
        
        int begin = 0;
        int res = 0;
        
        for(int end = 0; end < angles.size(); end++){
            while(angles.get(end) - angles.get(begin) > angle) begin++;
            res = Math.max(res, end - begin + 1);
        }
        
        res += countOfSameLoc;
        return res;
    }
}
