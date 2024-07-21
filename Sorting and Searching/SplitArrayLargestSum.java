public class SplitArrayLargestSum {
    int res=0;
    public int splitArray(int[] nums, int k) {
  
        int max =0; // sum of all elements in array
        int min=Integer.MIN_VALUE; // smallest value in a array
        for(int i : nums){
            max+=i;
            min = Math.max(min,i);
        }
  
        binarySearch(nums, k, min, max);
        return res;
        
    }
    public void binarySearch(int[] nums, int k , int start, int end){
        if(start>end) return;
        
        int mid = start+(end-start)/2;
        if(isFeasible(nums, k , mid)<=k){
            end = mid-1;
            res = mid;
            binarySearch(nums, k, start, end);
        }else{
            start = mid+1;
            binarySearch(nums, k, start, end);
        }
     
    }
    public int isFeasible(int[] nums, int k , int n){
        int c=0, total=0;
        for(int i : nums){
            if(total+i<=n) total+=i;
            else{
                c++;
                total=i;
            }
        }
        return c+1;
     }    
}
