package Strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    List<String> list;
    GenerateParentheses(){
        list = new ArrayList<>();
    }
    
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder("(");
        helper(sb, 1,0, n);
        return list;
    }
    public void helper(StringBuilder sb, int open, int close, int n){
        if(open == n && close == n){
            list.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append("(");
            helper(sb, open+1, close, n);
            sb.setLength(sb.length()-1);
        }
        if(close < n && open > close){
            sb.append(")");
            helper(sb, open, close+1, n);
            sb.setLength(sb.length()-1);
        }
    }
}
