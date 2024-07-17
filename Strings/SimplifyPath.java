package Strings;

import java.util.Iterator;
import java.util.Stack;


public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String s : arr){
            if(s.equals("") || s.equals(".")) continue;
            if(s.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push(s);

        }
        StringBuilder sb = new StringBuilder("");
        Iterator<String> itr = stack.iterator();

        while(itr.hasNext()){
            sb.append(itr.next());
            sb.append("/");
        }
        if(stack.isEmpty()) return "/";
        sb.setLength(sb.length() - 1);
        sb.insert(0,"/");

        return sb.toString();    
    }
}
