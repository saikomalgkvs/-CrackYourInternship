/* Find pair given difference */
import java.util.Arrays;

public class FindPainGivenDiff {
    public int findPair(int n, int x, int[] arr) {
        Arrays.sort(arr);
        
        int j=n-1;
        int i=n-2;
        
        while(i>=0 && j>=0){
            int diff = arr[j] - arr[i];
            if(diff == x && i!=j) return 1;
            else if(diff < x) i--;
            else{
                j--;
            }
        }
        return -1;
    }
}
