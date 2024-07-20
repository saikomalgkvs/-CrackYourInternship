import java.util.Arrays;

public class CircularTour {
    int tour(int petrol[], int distance[]){
        int psum = Arrays.stream(petrol).sum();
        int dsum = Arrays.stream(distance).sum();
        
        if(psum < dsum) return -1;
        
        int curr = 0;
        int idx = 0;
        
        for(int i=0; i<petrol.length; i++){
            curr = curr + (petrol[i] - distance[i]);
            if(curr < 0){
                idx = i+1;
                curr = 0;
            }
        }
        return idx;
    }
}
