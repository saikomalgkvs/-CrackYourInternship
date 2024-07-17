import java.util.*;

public class FindPeakElement
{
    public static int minCost(int[] arr, int n){
        Arrays.sort(arr);
        int x = 0;
        
        if(n%2 == 0) x = (arr[n/2] + arr[n/2 -1])/2;
        else x = arr[n/2];
        
        int diff = 0;
        for(int i : arr){
            diff += Math.abs( i - x );
        }
        return diff;
    }
	public static void main(String[] args) {
		int[] arr = {10,10,10,10,10,10,10,10,100};
		int n = arr.length;
		
		System.out.println(minCost(arr, n));
	}
}
