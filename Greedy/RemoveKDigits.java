// Problem link:
// https://leetcode.com/problems/remove-k-digits/description/

import java.math.*;
import java.util.Stack;
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<num.length(); i++){
            while(!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while(k!=0){
            stack.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.insert(0,stack.pop());
        }

        if(ans.length()==0) return "0";
        return new BigInteger(ans.toString()).toString();
    }
}    


