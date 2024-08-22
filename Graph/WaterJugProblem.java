// Problem link: https://www.geeksforgeeks.org/problems/two-water-jug-problem3402/1

public class WaterJugProblem {
    public static int minSteps(int m, int n, int d) {
        
        if(d > Math.max(m, n)) return -1;
        if(d % gcd(m, n) != 0) return -1;
        
        return Math.min(solve(m, n, d), solve(n, m, d));
    }
    
    public static int solve(int m, int n, int d) {
        int ans = 1;
        int j1 = m;
        int j2 = 0;
        
        while(j1 != d && j2 != d){
            int temp = Math.min(j1, n - j2);
            
            j2 += temp;
            j1 -= temp;
            ans++;
            
            if(j1 == d || j2 == d) break;
            if(j1 == 0){
                j1 = m;
                ans++;
            }
            if(j2 == n){
                j2 = 0;
                ans++;
            }
        }
        return ans;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
