package Arrays;
/* Maximum Points You Can Obtain from Cards */
public class MaximumPoints {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        int presum = 0;
        int n = cardPoints.length;
        for(int i=0; i<k; i++){
            presum += cardPoints[i];
        }
        max = Math.max(max, presum);

        int j = k-1;
        for(int i=n-1; i>=n-k; i--){
            presum = presum - cardPoints[j--] + cardPoints[i];
            max = Math.max(max, presum);
        }

        return max;
        // TIME LIMIT EXCEDED
        // int max = 0;
        // int n = cardPoints.length;
        // int count = k;
        // for(int i=k; i>=0; i--){
        //     int points = 0;
        //     int idx =  n-i;
        //     while(count-- > 0){
        //         points += cardPoints[idx++ % n];
        //         // System.out.print(idx++ % n + " ");
        //     }
        //     count = k;
        //     // System.out.println();
        //     max = Math.max(max, points);
        // }
        // return max;
    }
}
