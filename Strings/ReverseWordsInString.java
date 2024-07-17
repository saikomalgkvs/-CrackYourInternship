package Strings;

import java.util.Stack;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");

        Stack<String> stack = new Stack<>();
        for(String str : arr){
            if(!str.equals("")) stack.push(str);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}
