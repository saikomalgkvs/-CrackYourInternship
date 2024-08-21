// Problem: Largest area rectangular sub-matrix with equal number of 1's and 0's


import java.util.*;

public class LargestAreaRectangular {
    public static void main(String[] args){
		int arr[][] = {
            {0,1,0,1,0,1},
            {0,1,0,1,0,1},
            {0,1,0,1,0,1},
            {0,1,0,1,0,1},
            {0,1,0,1,0,1},
        };
		int m = arr.length;
        int n = arr[0].length;
		maxAreaRectWithSumZero(arr, m, n);
	}
    public static void maxAreaRectWithSumZero(int arr[][], int row, int col){
		int dp[] = new int[row];
		int startRow = 0;
        int endRow = 0;

		int y1 = -1, y2 = -1, x1 = -1, x2 = -1;
        
		int maxArea = 0;
		for (int left = 0; left < col; left++) {
			for (int right = left; right < col; right++) {
				for (int i = 0; i < row; i++){
					dp[i] += (arr[i][right] != 0) ? 1 : -1;
                }
				if(IsSumZero(dp, startRow,endRow, row)){
					int area = (right - left + 1) * (endRow - startRow + 1);

					if(maxArea < area){
						x1 = startRow;
						x2 = endRow;
						y1 = left;
						y2 = right;
						maxArea = area;
					}
				}
			}
		}

		if (maxArea == 0) System.out.print("No such rectangular submatrix exists:");
		else {
			System.out.println("(Top, Left): " + "(" + x1 + ", " + y1 + ")");
			System.out.println("(Bottom, Right): " + "(" + x2 + ", " + y2 + ")");
			System.out.println("Area: " + maxArea);
		}
	}
	public static boolean IsSumZero(int arr[], int start, int end, int n){
		int sum[] = new int[n];
		Map<Integer, Integer> um = new HashMap<Integer, Integer>();

		sum[0] = arr[0];
		for(int i = 1; i < n; i++){
			sum[i] = sum[i - 1] + arr[i];
        }

		int maxLen = 0;
		for(int i = 0; i < n; i++){
			if(sum[i] == 0){
				start = 0;
				end = i;
				maxLen = i+1;
			}
			else if(um.get(sum[i]) == null) um.put(sum[i], i);
			else{
                if (maxLen < (i - um.get(sum[i]))) {
					maxLen = i - um.get(sum[i]);
					start = i - um.get(sum[i]) + 1;
					end = i;
                }
            }
		}
		return maxLen != 0;
	}
}