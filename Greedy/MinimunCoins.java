// Problem link:
// https://www.geeksforgeeks.org/minimum-cost-for-acquiring-all-coins-with-k-extra-coins-allowed-with-every-coin/

import java.util.Arrays;
import java.util.Scanner;

public class MinimunCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of coins: ");
        int n = sc.nextInt();
        
        System.out.print("Enter number of coins: ");
        int[] coins = new int[n];
        for(int i=0; i<n; i++){
            coins[i] = sc.nextInt();
        }
        
        System.out.print("Enter coins can be choosen for free after buying a coin (k): ");
        int k = sc.nextInt();

        System.out.println("Minimun cost to collect all conins: " + mincost(coins, n, k));
        sc.close();
    }
    public static int mincost(int[] coins, int n, int k){
        int cost = 0;
        Arrays.sort(coins);
        
        for(int i=0; i<n; i++){
            cost += coins[i];
            n -= (k+1);
            if(n <=0) break;
        }
        return cost;
    }
}
