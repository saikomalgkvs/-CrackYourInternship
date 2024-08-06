// Problem link:
// https://www.geeksforgeeks.org/problems/partition-array-to-k-subsets/1

package Backtracking;
import java.util.Arrays;

public class PartitionArrayToKSubsets {
    public boolean isKPartitionPossible(int[] a, int n, int k) {
        int totalSum = Arrays.stream(a).sum();

        if (totalSum % k != 0) return false;

        int targetSum = totalSum / k;
        Arrays.sort(a);

        boolean[] visited = new boolean[n];
        return canPartition(a, n-1, k, 0, targetSum, visited);
    }
    private boolean canPartition(int[] a, int index, int k, int currentSum, int targetSum, boolean[] visited) {

        if(k == 0) return true;
        
        if(currentSum == targetSum) return canPartition(a, a.length - 1, k - 1, 0, targetSum, visited);

        for(int i = index; i >= 0; i--){
            if(visited[i]) continue;

            if(i + 1 < a.length && a[i] == a[i + 1] && !visited[i + 1]) continue;

            if(currentSum + a[i] <= targetSum){
                visited[i] = true;

                if(canPartition(a, i - 1, k, currentSum + a[i], targetSum, visited)) return true;

                visited[i] = false;
            }
        }
        return false;
    }
}
