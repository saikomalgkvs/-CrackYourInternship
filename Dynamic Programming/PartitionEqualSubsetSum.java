// Problem link: https://www.geeksforgeeks.org/problems/subset-sum-problem2014/1

public class PartitionEqualSubsetSum {
    static int equalPartition(int N, int arr[]){
        int sum =0;
        
        for(int num : arr){
            sum += num;
        }
        
        if(sum % 2 != 0) return 0;
        
        return checkSubset(arr, N, sum/2);
    }
    static int checkSubset(int[] arr, int n, int sum){
        boolean[][] dp = new boolean[n+1][sum+1];
        
        for(int i=0; i<=n; i++){
            dp[i][0] = true;
        }
        
        for(int j=1; j<=n; j++){
            dp[0][j] = false;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){;
                int num = arr[i-1];
                if(num <= j) dp[i][j] = dp[i-1][j-num] || dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][sum] ? 1 : 0;
    }    
}
