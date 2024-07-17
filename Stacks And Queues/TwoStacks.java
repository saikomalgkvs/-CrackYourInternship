/* Implement two stack in an array */

class TwoStacks {
    private int[] arr;
    private int top1;
    private int top2;
    private int size;
    
    TwoStacks() {
        size = 1000;
        arr = new int[size];
        top1 = -1;
        top2 = size;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        top1++;
        arr[top1] = x;
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        top2--;
        arr[top2] = x;
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        if(top1 == -1) return -1;
        else return arr[top1--];
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        if(top2 == size) return -1;
        else return arr[top2++];
    }
}
