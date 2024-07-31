public class AllocateMinimumPages {
    public static long findPages(int n, int[] arr, int m) {
        if(m > n) return -1;
        
        int start = arr[0];
        int end = 0;
        
        for(int i : arr){
            start = Math.max(start, i);
            end += i;
        }
        
        // binary search
        while(start <= end){
            int mid = start + (end - start)/2;
            int students = helper(arr, mid);
            
            if(students > m) start = mid + 1;
            else end = mid - 1;
        }
        
        return start;
    }
    public static int helper(int[] arr, int mid){
        int count = 1;
        long pages = 0;
        
        for(int i=0; i<arr.length; i++){
            pages += arr[i];
            
            if(pages > mid){
                count += 1;
                pages = arr[i];
            }
        }
        return count;
    }    
}
