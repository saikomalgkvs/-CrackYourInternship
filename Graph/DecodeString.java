import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> prev = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        int n = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                n = n*10 + (c - '0'); // since number can be more than one digit;
            }
            else if(c == '['){
                count.push(n);
                n = 0;
                prev.push(sb);
                sb = new StringBuilder();
            }
            else if(c == ']'){
                int i = count.pop();
                StringBuilder temp = sb;
                sb = prev.pop();

                while(i-- > 0){
                    sb.append(temp);
                }
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
