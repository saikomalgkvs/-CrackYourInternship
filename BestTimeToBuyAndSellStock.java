class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];

        int profit = 0;

        for(int i=1; i<prices.length; i++){
            int p = prices[i];
            if(p > min){
                profit = (profit > p-min) ? profit : p-min;
            }
            else min = p;
        }

        return profit;
    }
}