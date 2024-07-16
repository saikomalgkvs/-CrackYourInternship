package Mathematical;

public class ProductArrayPuzzle {
    public static long[] productExceptSelf(int nums[], int n) 
	{
	    long[] P = new long[n];
	    
        long prod = 1;
        int flag = 0;
        int zeroAt = -1;
        for(int i=0; i<n; i++){
            if(nums[i]==0){
                flag++;
                zeroAt = i;
            }
            else prod *= nums[i];
        }
        if(flag>0){
            if(flag>1) return P;
            else P[zeroAt] = prod;
        }
        else{
            for(int i=0; i<n; i++){
                P[i] = prod/nums[i];
            }
        }
        return P;
	} 
}
