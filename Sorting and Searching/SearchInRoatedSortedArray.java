public class SearchInRoatedSortedArray {
    public int search(int[] nums, int target) {
        int peak = 0;
        for( ; peak<nums.length-1; peak++){
            if(nums[peak] > nums[peak+1]) break;
        }
        int result = binarySearch(nums, 0, peak, target);
        if(result == -1) return binarySearch(nums, peak+1, nums.length-1, target);
        else return result;
    }
    int binarySearch(int[] arr, int i, int j, int key){
        if(i>j) return -1;
        int mid = i + (j-i)/2;
        
        if(arr[mid] == key) return mid;
        else if(arr[mid] > key) return binarySearch(arr, i, mid-1, key);
        else return binarySearch(arr, mid+1, j, key);
    }
}
