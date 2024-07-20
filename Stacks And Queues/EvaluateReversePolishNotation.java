import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String i : tokens){
            if(i.equals("+")){
                //int b = stack.pop();
                //int a = stack.pop();
                stack.push(stack.pop()+stack.pop());
            }
            else if(i.equals("-")){
                //int b = stack.pop();
                //int a = stack.pop();
                stack.push(-stack.pop()+stack.pop());
            }
            else if(i.equals("*")){
                //int b = stack.pop();
                //int a = stack.pop();
                stack.push(stack.pop()*stack.pop());
            }
            else if(i.equals("/")){
                int b = stack.pop();
                //int a = stack.pop();
                stack.push(stack.pop()/b);
            }
            else{
                stack.push(Integer.parseInt(i));
            }
        }
        return stack.pop();
    }
}
