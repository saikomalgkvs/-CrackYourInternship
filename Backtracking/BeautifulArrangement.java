// Problem link:
// https://leetcode.com/problems/beautiful-arrangement/

package Backtracking;

public class BeautifulArrangement {
    int count;
    public int countArrangement(int n) {
        count = 0;
        boolean[] perm = new boolean[n+1];
        backtrack(perm, 1, n);
        return count;
    }
    private void backtrack(boolean[] perm, int i, int max){
        if(i == max+1){
            count++;
            return;
        }
        for(int num = 1; num <= max; num++){
            if((i % num == 0 || num % i == 0) && !perm[num]){
                perm[num] = true;
                backtrack(perm, i+1, max);
                perm[num] = false;
            }
        }
    }
}
