import java.util.Stack;

public class RemoveAllAdjacentDuplicates {
    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> dup = new Stack<>();

        int count = 1;
        dup.push(count);
        for(char c : s.toCharArray()){
            if(!dup.isEmpty() && dup.peek() == k){
                for(int i=0; i<k; i++) stack.pop();
                dup.pop();
            }

            if(!stack.isEmpty() && stack.peek() == c){
                dup.push(dup.pop() + 1);
            }
            else{
                dup.push(count);
                count = 1;
            }
            if(count == k) dup.push(count);
            stack.push(c);
        }

        if(!dup.isEmpty() && dup.peek() == k){
            for(int i=0; i<k; i++) stack.pop();
            dup.pop();
        }
        
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
