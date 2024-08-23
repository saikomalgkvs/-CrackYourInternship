class Solution {
    public int[][] minCashFlow(int[][] transaction, int n) {
        int inFlow[] = new int[n];
        int outFlow[] = new int[n];
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                inFlow[i] += transaction[j][i];        
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                outFlow[i] += transaction[i][j];        
            }
        }
        
        int amount[] = new int[n];
        
        for(int i=0;i<n;i++){
            amount[i] = inFlow[i]-outFlow[i];
        }
        
        int result[][] = new int[n][n];
        calculateAns(amount,result);
        
        
        return result;
        
    }
    public static void calculateAns(int amount[],int ans[][]){
        
        int maxI = getMax(amount);
        int minI = getMin(amount);
        
        if(amount[maxI]==0 && amount[minI]==0) return;;
        
        int min = Math.min(amount[maxI],-amount[minI]);    
        amount[maxI] -= min;
        amount[minI] += min;
        
        ans[minI][maxI] = min;
        calculateAns(amount,ans);
    }
    
    public static int getMax(int amount[]){
        int index = 0;
        int val = Integer.MIN_VALUE;
        for(int i=0; i<amount.length; i++){
            if(amount[i] > val){
                val = amount[i];
                index = i;
            }
        }
        return index;
    }
    public static int getMin(int amount[]){
        int index = 0;
        int val = Integer.MAX_VALUE;
        for(int i=0;i<amount.length;i++){
            if(amount[i]<val){
                val = amount[i];
                index = i;
            }
        }
        return index;
    }
}
