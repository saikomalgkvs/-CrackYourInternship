import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int s = temperatures.length;
        Stack<Integer> a = new Stack<>();
        int[] answer = new int[s];
        for(int i = 0; i<s; i++){
            while(!a.isEmpty() && temperatures[a.peek()]<temperatures[i]){
                answer[a.peek()] = i-a.pop();
            }
            a.push(i);
        }
        return answer;
    }
}
