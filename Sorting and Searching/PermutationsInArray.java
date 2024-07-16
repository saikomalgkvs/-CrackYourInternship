import java.util.Arrays;

public class PermutationsInArray {
    public boolean isPossible(long a[], long b[], int n, long k) {
        Arrays.sort(a);
        Arrays.sort(b);
        
        int i=0; int j=n-1;
        
        for( ; i<j; i++,j--){
            long t = b[i];
            b[i] = b[j];
            b[j] = t;
        }
        
        i=0;
        j=0;
        for( ; i<n; i++, j++){
            if(a[i] + b[i] < k) return false;
        }
        return true;
    }
}
