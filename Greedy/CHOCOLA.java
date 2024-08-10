// Problem link: https://www.spoj.com/problems/CHOCOLA/

import java.util.*;

public class CHOCOLA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for(int i=0; i<testCases; i++){
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            int[] x = new int[m];
            int[] y = new int[n];
            
            for(int j=0; j<m-1; j++){
                x[j] = sc.nextInt();
            }
            for(int j=0; j<n-1; j++){
                y[j] = sc.nextInt();
            }
            System.out.println(minCostToBreakChocolate(m, n, x, y));
        }
        sc.close();
    }

    public static int minCostToBreakChocolate(int m, int n, int[] xCosts, int[] yCosts) {
        Arrays.sort(xCosts);
        Arrays.sort(yCosts);

        reverse(xCosts);
        reverse(yCosts);

        int hcuts = 1;
        int vcuts = 1;
        int cost = 0;

        int i = 0, j = 0;

        while (i < m - 1 && j < n - 1) {
            if (xCosts[i] > yCosts[j]) {
                cost += xCosts[i] * hcuts;
                vcuts++;
                i++;
            } else {
                cost += yCosts[j] * vcuts;
                hcuts++;
                j++;
            }
        }

        while (i < m - 1) {
            cost += xCosts[i] * hcuts;
            i++;
        }

        while (j < n - 1) {
            cost += yCosts[j] * vcuts;
            j++;
        }

        return cost;
    }

    private static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
}
