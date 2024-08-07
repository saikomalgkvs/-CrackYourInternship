// Problem link:
// https://www.geeksforgeeks.org/problems/cutted-segments1642/1

public class MaximizeTheCutSegments {
    public int maximizeCuts(int n, int x, int y, int z){
        int[] dp = new int[n+1]; // stores number of maximum segments, 
        int[] cuts = {x,y,z};
        
        for(int j=1; j<=n; j++){ // j is length of line segment
            
            int a = getCuts(dp, j, cuts[0]);
            int b = getCuts(dp, j, cuts[1]);
            int c = getCuts(dp, j, cuts[2]);
            
            dp[j] = Math.max(a, Math.max(b,c));
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n];
    }
    private int getCuts(int[] dp, int line, int len){
        if(line < len) return 0;
        else if(line == len) return 1;
        else{
            if(dp[line - len] == 0) return 0;
            else return dp[line - len] + 1;
        }
    }
}
