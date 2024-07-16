import java.util.Deque;
import java.util.LinkedList;

class myStack{
    private Deque<Integer> q1;
    myStack(){
        q1 = new LinkedList<>();
    }

    public void push(int x) {
        q1.addLast(x);
    }
    
    public int pop() {
        return q1.removeLast();
    }
    
    public int top() {
        return q1.peekLast();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
class myQueue{
    private Deque<Integer> q1;
    myQueue(){
        q1 = new LinkedList<>();
    }

    public void enqueue(int x) {
        q1.addLast(x);
    }
    
    public int dequeue() {
        return q1.removeFirst();
    }
    
    public int peek() {
        return q1.peekFirst();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
public class ImplementStackAndQueueUsingDeque {
    public static void main(String[] args) {
        myStack stack = new myStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        System.out.println("Top element: " + stack.top());
        System.out.println("Is stack empty: " + stack.empty());
        System.out.println();
        
        myQueue queue = new myQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        System.out.println("Top element: " + queue.peek());
        System.out.println("Is stack empty: " + queue.empty());
        System.out.println();
    }
}
