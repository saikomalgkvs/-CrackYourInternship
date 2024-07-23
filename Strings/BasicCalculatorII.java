package Strings;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        int cur = 0;
        char operator = '+';
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) cur = cur * 10 + (ch - '0');

            if(!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1){

                if (operator == '+') stack.push(cur);
                else if (operator == '-') stack.push(-cur);
                else if (operator == '*') stack.push(stack.pop() * cur);
                else if (operator == '/') stack.push(stack.pop() / cur);
                
                operator = ch;
                cur = 0;
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
