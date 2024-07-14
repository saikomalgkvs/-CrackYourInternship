package Arrays;
import java.util.*;
public class ChocolateDistribution {
    public static int minimumDiff(int[] arr, int m){
        Arrays.sort(arr);
        int i=0;
        int j=m-1;

        int diff = Integer.MAX_VALUE;

        while(j<arr.length){
            int d = arr[j] - arr[i];
            diff = (diff < d)? diff : d;
            i++;
            j++;
        }

        return diff;
    }
    public static void main(String[] args) {
        int[] packets = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m = 7;
        System.out.println(minimumDiff(packets, m));
    }
}
