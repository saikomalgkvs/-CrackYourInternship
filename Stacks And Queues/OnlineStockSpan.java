import java.util.Stack;

public class OnlineStockSpan {
    Stack<int[]> stack;

    public OnlineStockSpan() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        while(stack.size()>0 && stack.peek()[0] <= price){
            count += stack.pop()[1];
        }
        stack.push(new int[]{price, count});
        return count;
    }
}
