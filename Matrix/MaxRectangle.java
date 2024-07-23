package Matrix;

import java.util.Stack;

public class MaxRectangle {
    public int maxArea(int M[][], int n, int m) {
        int maxArea = getMax(M[0]);
        
        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                if(M[i-1][j] == 0 || M[i][j] == 0) continue;
                else{
                    M[i][j] += M[i-1][j];
                }
            }
            maxArea = Math.max(maxArea, getMax(M[i]));
        }
        return maxArea;
        
    }
    public int getMax(int[] arr){
        Stack<Integer> stack = new Stack<Integer>();
        
        int maxArea = 0;
        
        int i=0;
        while(i<arr.length){
            if(stack.isEmpty() || arr[stack.peek()] <= arr[i]) stack.push(i++);
            else{
                int top = stack.pop();
                int mult = (stack.isEmpty())? i : i-stack.peek()-1;
                int area = arr[top] * mult;
                maxArea = Math.max(maxArea, area);
            }
        }
        
        while(!stack.isEmpty()){
            int top = stack.pop();
            int mult = (stack.isEmpty())? i : i-stack.peek()-1;
            int area = arr[top] * mult;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
