import java.util.Arrays;

public class CheckReverseSubarray {
    public static boolean canBeSorted(int[] arr, int n){
        int[] sortedArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArr);
        
        int i=0;
        while(i++ < n){
            if(arr[i] != sortedArr[i]) break;
        }
        
        int j=n-1;
        while(j-- >= 0){
            if(arr[j] != sortedArr[j]) break;
        }
        
        while(i++ <= j--){
            if(arr[i] != sortedArr[j]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,4,7,6};
        int n = arr.length;

        System.out.println(canBeSorted(arr, n));
    } 
}
