// Problem link:
// https://www.geeksforgeeks.org/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum-set-2/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TugOfWar {
    static int minDiff;
    static int[] result;
    
    public static ArrayList<ArrayList<Integer>> minDifference(int n, int[] arr) {
        minDiff = Integer.MAX_VALUE;
        result = new int[2];
        
        int totalSum = 0;
        for (int num : arr) totalSum += num;
        
        List<Integer> subset1 = new ArrayList<>();
        List<Integer> subset2 = new ArrayList<>();
        
        findSubsets(arr, 0, 0, 0, subset1, subset2, totalSum);
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(result[0])));
        res.add(new ArrayList<>(Arrays.asList(result[1])));
        return res;
    }
    
    private static void findSubsets(int[] arr, int index, int sum1, int sum2, List<Integer> subset1, List<Integer> subset2, int totalSum) {
        if (index == arr.length) {
            if (subset1.size() == (arr.length + 1) / 2 && subset2.size() == arr.length / 2) {
                int diff = Math.abs(sum1 - sum2);
                if (diff < minDiff) {
                    minDiff = diff;
                    result[0] = sum1;
                    result[1] = sum2;
                }
            }
            return;
        }
        
        // Include current element in subset1 if not full
        if (subset1.size() < (arr.length + 1) / 2) {
            subset1.add(arr[index]);
            findSubsets(arr, index + 1, sum1 + arr[index], sum2, subset1, subset2, totalSum);
            subset1.remove(subset1.size() - 1);
        }
        
        // Include current element in subset2 if not full
        if (subset2.size() < arr.length / 2) {
            subset2.add(arr[index]);
            findSubsets(arr, index + 1, sum1, sum2 + arr[index], subset1, subset2, totalSum);
            subset2.remove(subset2.size() - 1);
        }
    }
}
