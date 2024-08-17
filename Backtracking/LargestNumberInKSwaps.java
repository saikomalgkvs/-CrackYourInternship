// Problem link:
// https://www.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1

package Backtracking;

public class LargestNumberInKSwaps {
    static String max;
    public static String findMaximumNum(String str, int k){
        max = "";
        backtrack(str, 0, k, 0);
        return max;
    }
    private static void backtrack(String str, int i, int k, int swaps){
        // System.out.println(str);
        if(swaps == k || i==str.length()){
            max = findMax(max, str);
            return;
        }
        
        for(int j=i+1; j<str.length(); j++){
            if(str.charAt(i) < str.charAt(j)){
                str = swap(str, i, j);
                backtrack(str, i+1, k, swaps+1);
                str = swap(str, j, i);
            }
        }
        backtrack(str, i+1, k, swaps);
    }
    private static String swap(String str, int i, int j){
        char[] arr = str.toCharArray();
        
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        return new String(arr);
    }
    private static String findMax(String a1, String a2){
        int l1 = a1.length();
        int l2 = a2.length();
        
        if((l1 > l2) && (a1.charAt(0)!='0')) return a1;
        if((l2 > l1) && (a2.charAt(0)!='0')) return a2;
        
        int i=0;
        while(i < l1){
            int digit1 = a1.charAt(i) - '0';
            int digit2 = a2.charAt(i) - '0';
            if(digit1 > digit2) return a1;
            else if(digit2 > digit1) return a2;
            else i++;
        }
        return a1; // if a1 and a2 are same;
    }
}
